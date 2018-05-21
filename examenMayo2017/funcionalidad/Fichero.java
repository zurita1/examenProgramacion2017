package examenMayo2017.funcionalidad;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Se encarga de la lectura/escritura en el sistema de ficheros
 * 
 * @author MaríaLourdes
 *
 */
public class Fichero implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String readUTF;
	private static LocalDate readObject;
	public static General general;

	public static void escribir(LocalDate localDate, File file) throws ErrorAlGuardarException {
		file = annadirExtension(file);

		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file)))) {
			objectOutputStream.writeObject(localDate);
			objectOutputStream.writeUTF(Datos.RAFAEL_GARCIA_ZURITA);
		} catch (IOException e) {
			throw new ErrorAlGuardarException("Error al guardar del fichero.");
		}
	}

	/**
	 * Lee de un fichero indicado y devuelve lo leído
	 * 
	 * @param file
	 *            fichero a leer
	 * @return Datos leídos (fecha y nombre)
	 * @throws ErrorAlLeerException
	 *             Error de lectura en el fichero
	 */
	public static Datos leer(File file) throws ErrorAlLeerException {

		try (ObjectInputStream objectInputStream = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(file)))) {
			readObject = (LocalDate) objectInputStream.readObject();
			readUTF = objectInputStream.readUTF();
			return new Datos(readObject, readUTF);
		} catch (IOException | ClassNotFoundException e) {
			throw new ErrorAlLeerException("Error al leer el fichero.");
		}
	}

	/**
	 * Añade la extensión fec sólo en caso de ser necesario
	 * 
	 * @param file
	 * @return Fichero con la extensión ".fec"
	 */
	private static File annadirExtension(File file) {

		String path = file.getPath();
		if (!path.endsWith(".fec"))
			return new File(path + ".fec");
		return file;
	}
}