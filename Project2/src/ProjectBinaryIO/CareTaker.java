package ProjectBinaryIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * CareTaker creates a file in the working directory in which it can write and read Mementos to.
 * Has methods to write a Memento to storage, and to read the Memento back as a Memento.
 * @author Alexander Dung
 *
 */
public class CareTaker {
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private String fileDest;
	
	public CareTaker() {
		fileDest = "cones.dat";
		File file = new File(fileDest);
		try {
			//create the file
			file.createNewFile();
			//MUST create the output stream first, or else input stream hangs.
			this.writer = new ObjectOutputStream(new FileOutputStream(fileDest));
			this.reader = new ObjectInputStream(new FileInputStream(fileDest));
		}
		catch(FileNotFoundException e) {
			System.out.println("CareTaker Construction: File cones.bin could not be created/found.");
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println("CareTaker Construction: IOException thrown while constructing CareTaker.");
			e.printStackTrace();
		}
	}
	
	public void saveMemento(Memento toSave) {
		try {
			//save Memento to file
			this.writer.writeObject(toSave);
		}
		catch(IOException e) {
			System.out.println("CareTaker: Problem saving current state of IceCreamCone.");
			e.printStackTrace();
		}
	}
	
	public Memento readMemento() {
		Memento prevState = new Memento(1, "vanila", "regular");
		try{
			prevState = (Memento)reader.readObject();
		}
		catch(IOException e) {
			System.out.println("CareTaker: IOException thrown while reading Memento from file.");
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			System.out.println("CareTaker: ClassNotFoundException thrown while reading Memento from file.");
			e.printStackTrace();
		}
		return prevState;
	}
	
	public void closeWriter() {
		try {
			this.writer.close();
		}
		catch(IOException e) {
			System.out.println("CareTaker: IOException thrown while closing ObjectOutputStream.");
			e.printStackTrace();
		}
	}
	
	public void closeReader() {
		try {
			this.reader.close();
		}
		catch(IOException e){
			System.out.println("CareTaker: IOException thrown while closing ObjectInputStream.");
			e.printStackTrace();
		}
	}
}
