package ch.makery.address.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Clase auxiliar para manejar fechas
 * 
 */
public class DateUtil {
	
	/** Patrón empleado para convertir fechas */
	private static final String DATE_PATTERN = "dd/MM/yyyy";
	
	/** Objeto para formatear fechas */
	private static final DateTimeFormatter DATE_FORMATTER = 
			DateTimeFormatter.ofPattern(DATE_PATTERN);
	
	/**
     * Devuelve la fecha que llega como parámetro como un string formateado
     * 
     * @param date es el objeto con la fecha
     * @return String formateado
     */
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /**
     * Convierte un String con un formato de fecha en un objeto LocalDate
     * 
     * Devuelve null si el formato es incorrecto y no se puede realizar la conversión
     * 
     * @param dateString la cadena de texto con la fecha
     * @return devuelve el objeto LocalDate o null en caso de error
     */
    public static LocalDate parse(String dateString) {
        try {
        	return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Comprueba si un String es una fecha válida
     * 
     * @param dateString
     * @return true si la fecha es válida o false en caso contrario
     */
    public static boolean validDate(String dateString) {
    	// Try to parse the String.
    	return DateUtil.parse(dateString) != null;
    }
}