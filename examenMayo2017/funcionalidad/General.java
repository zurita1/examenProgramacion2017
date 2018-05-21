package examenMayo2017.funcionalidad;

import java.io.File;
import java.time.LocalDate;

public class General {
	/**
	 * Nombre del fichero a mostrar al usuario en caso de no haber fichero
	 * abierto/guardado. Este valor es {@value}
	 */
	private static final String SIN_NOMBRE = "Sin nombre";
	/**
	 * Indica si la fecha se ha modificado
	 */
	private static boolean modificado = true;
	/**
	 * Indica fichero abierto/guardado
	 */
	private static File file;
	/**
	 * Indica fecha. Siempre se comienza con la fecha actual
	 */
	public static LocalDate localDate = LocalDate.now();

	/**
	 * @return the modificado
	 */
	public static boolean isModificado() {
		return modificado;
	}

	/**
	 * @param modificado
	 *            the modificado to set
	 */
	public static void setModificado(boolean modificado) {
		General.modificado = modificado;
	}

	/**
	 * @return the file
	 */
	public static File getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public static void setFile(File file) {
		General.file = file;

	}

	/**
	 * Obtiene el nombre del fichero a mostrar al usuario. En caso de no haber
	 * fichero abierto/guardado, devuelve {@value #SIN_NOMBRE}
	 * 
	 * @return Nombre del fichero a mostrar al usuario
	 */
	public static String getNombreFile() {
		if (getFile() == null)
			return General.SIN_NOMBRE;
		return getFile().getName();
	}

	/**
	 * @return the localDate
	 */
	public static LocalDate getLocalDate() {
		return localDate;
	}

	/**
	 * @param localDate
	 *            the localDate to set
	 */
	public static void setLocalDate(LocalDate localDate) {
		General.localDate = localDate;

	}

	/**
	 * Permite crear un nuevo fichero
	 */
	public static void nueva() {
		setFile(null);
		setModificado(true);
		setLocalDate(LocalDate.now());
	}

	/**
	 * Guarda en el fichero
	 * 
	 * @throws ErrorAlGuardarException
	 */
	public static void guardar() throws ErrorAlGuardarException {
		Fichero.escribir(localDate, file);
		setModificado(false);
	}

	/**
	 * Guarda los datos en un fichero y actualiza el sistema
	 * 
	 * @param file
	 * @throws ErrorAlGuardarException
	 */
	public static void guardar(File file) throws ErrorAlGuardarException {
		Fichero.escribir(getLocalDate(), file);
		setModificado(false);
		setFile(file);
	}

	/**
	 * Lee los datos de un fichero y actualiza el sistema
	 * 
	 * @param selectedFile
	 * @throws ErrorAlLeerException
	 */
	public static void abrir(File selectedFile) throws ErrorAlLeerException {
		Fichero.leer(selectedFile);

		setModificado(false);
		setFile(selectedFile);
	}

}