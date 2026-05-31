package proyecto.logica;

import proyecto.modelo.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/**
 * Parsea un fichero XML con la siguiente estructura:
 *
 * <gym>
 *   <socios>
 *     <socio>
 *       <Nombre>...</Nombre>
 *       <Apellido1>...</Apellido1>
 *       <Apellido2>...</Apellido2>
 *       <DNI>...</DNI>
 *       <Telefono>...</Telefono>
 *       <Correo>...</Correo>
 *       <Fecha_Alta>2024-01-10</Fecha_Alta>
 *       <Estado>Alta</Estado>
 *     </socio>
 *   </socios>
 *   <planes>
 *     <plan>
 *       <Socio_ID>6</Socio_ID>
 *       <Descripcion>...</Descripcion>
 *       <Fecha_Inicio>2024-01-10</Fecha_Inicio>
 *       <Fecha_Fin>2024-02-10</Fecha_Fin>
 *     </plan>
 *   </planes>
 *   <pagos> ... </pagos>
 *   <asistencias> ... </asistencias>
 *   <usuarios> ... </usuarios>
 * </gym>
 *
 * Ubicación: proyecto.logica
 */
public class XmlParser {

    // Formato de fecha esperado en el XML: YYYY-MM-DD
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    /** Devuelve un mapa con las listas de cada entidad. */
    public Map<String, List<?>> parsear(File fichero) throws Exception {
        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = fac.newDocumentBuilder();
        Document doc = db.parse(fichero);
        doc.getDocumentElement().normalize();

        Map<String, List<?>> resultado = new LinkedHashMap<>();
        resultado.put("socios",      parseSocios(doc));
        resultado.put("planes",      parsePlanes(doc));
        resultado.put("pagos",       parsePagos(doc));
        resultado.put("asistencias", parseAsistencias(doc));
        resultado.put("usuarios",    parseUsuarios(doc));
        return resultado;
    }

    // ── Socios ────────────────────────────────────────────────────────── //
    private List<Socio> parseSocios(Document doc) throws Exception {
        List<Socio> lista = new ArrayList<>();
        NodeList nodos = doc.getElementsByTagName("socio");
        for (int i = 0; i < nodos.getLength(); i++) {
            Element el = (Element) nodos.item(i);
            // Usamos el constructor lleno de tu Socio
            Socio s = new Socio(
                texto(el, "Nombre"),
                texto(el, "Apellido1"),
                texto(el, "Apellido2"),
                texto(el, "DNI"),
                texto(el, "Telefono"),
                texto(el, "Correo"),
                SDF.parse(texto(el, "Fecha_Alta")),
                texto(el, "Estado")
            );
            lista.add(s);
        }
        return lista;
    }

    // ── Planes ────────────────────────────────────────────────────────── //
    private List<Plan> parsePlanes(Document doc) throws Exception {
        List<Plan> lista = new ArrayList<>();
        NodeList nodos = doc.getElementsByTagName("plan");
        for (int i = 0; i < nodos.getLength(); i++) {
            Element el = (Element) nodos.item(i);
            int socioId = entero(el, "Socio_ID");
            String importeStr = texto(el, "Importe");
            double importe = importeStr.isEmpty() ? 0.0 : Double.parseDouble(importeStr);
            Plan p = new Plan(
                0,
                socioId,
                texto(el, "Descripcion"),
                importe,
                SDF.parse(texto(el, "Fecha_Inicio")),
                SDF.parse(texto(el, "Fecha_Fin"))
            );
            lista.add(p);
        }
        return lista;
    }

    // ── Pagos ─────────────────────────────────────────────────────────── //
    private List<Pago> parsePagos(Document doc) throws Exception {
        List<Pago> lista = new ArrayList<>();
        NodeList nodos = doc.getElementsByTagName("pago");
        for (int i = 0; i < nodos.getLength(); i++) {
            Element el = (Element) nodos.item(i);
            Pago p = new Pago(
                entero(el, "Socio_ID"),
                SDF.parse(texto(el, "Fecha_Pago")),
                Double.parseDouble(texto(el, "Importe")),
                texto(el, "Estado")
            );
            lista.add(p);
        }
        return lista;
    }

    // ── Asistencias ───────────────────────────────────────────────────── //
    private List<Asistencia> parseAsistencias(Document doc) throws Exception {
        List<Asistencia> lista = new ArrayList<>();
        NodeList nodos = doc.getElementsByTagName("asistencia");
        for (int i = 0; i < nodos.getLength(); i++) {
            Element el = (Element) nodos.item(i);
            Asistencia a = new Asistencia(
                0,
                entero(el, "Socio_ID"),
                LocalDate.parse(texto(el, "Fecha_Asistencia")),
                java.time.LocalTime.parse(texto(el, "Hora_entrada"))
            );
            lista.add(a);
        }
        return lista;
    }

    // ── Usuarios ──────────────────────────────────────────────────────── //
    private List<Usuario> parseUsuarios(Document doc) {
        List<Usuario> lista = new ArrayList<>();
        NodeList nodos = doc.getElementsByTagName("usuario");
        for (int i = 0; i < nodos.getLength(); i++) {
            Element el = (Element) nodos.item(i);
            // Usamos el constructor sin ID de tu Usuario
            Usuario u = new Usuario(
                entero(el, "Plan_ID"),
                texto(el, "Usuario"),
                texto(el, "Contrasena"),
                texto(el, "Rol")
            );
            lista.add(u);
        }
        return lista;
    }

    // ── Utilidades ────────────────────────────────────────────────────── //
    private String texto(Element parent, String tag) {
        NodeList nl = parent.getElementsByTagName(tag);
        if (nl.getLength() == 0) return "";
        Node n = nl.item(0).getFirstChild();
        return (n == null) ? "" : n.getNodeValue().trim();
    }

    private int entero(Element parent, String tag) {
        String v = texto(parent, tag);
        return v.isEmpty() ? 0 : Integer.parseInt(v);
    }
}
