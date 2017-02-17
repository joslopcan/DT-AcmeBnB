
package utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CreateConverters {

	public static void main(String[] args) {
		Boolean continua = true;

		String directorio = "C:\\Documents and Settings\\Student\\Desktop\\Converters"; //Directorio donde guardar los converters
		while (continua) {
			//Introducimos la clase interesada
			System.out.println("Empezamos el programa");
			System.out.println("Por favor introduzca una cadena por teclado:");
			String clase = "";
			Scanner entradaEscaner = new Scanner(System.in);

			clase = entradaEscaner.nextLine();
			//		entradaEscaner.close();

			if (check(clase)) {
				System.out.println("Por favor comportese");
				break;
			}
			// Creación del primer converter

			String firstConverterName = "StringTo" + clase + "Converter.java";
			String firstConverterContent = "package converters;\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.core.convert.converter.Converter;\nimport org.springframework.stereotype.Component;\nimport org.springframework.transaction.annotation.Transactional;\nimport repositories.ConsumerRepository;\nimport domain.Consumer;\n@Component\n@Transactional\npublic class StringToConsumerConverter implements Converter<String, Consumer> {\n\n	@Autowired\n	ConsumerRepository consumerRepository;\n\n	@Override\n	public Consumer convert(String text) {\n		Consumer result;\n		int id;\n\n		try {\n			id = Integer.valueOf(text);\n			result = consumerRepository.findOne(id);\n		} catch (Throwable oops) {\n			throw new IllegalArgumentException(oops);\n		}\n\n		return result;\n	}\n\n}";
			File converterFolder = new File("C:\\Documents and Settings\\Student\\Desktop");

			File converter1 = new File(directorio, firstConverterName);
			firstConverterContent = firstConverterContent.replaceAll("consumer", clase.toLowerCase());
			firstConverterContent = firstConverterContent.replaceAll("Consumer", clase);

			String[] content1 = firstConverterContent.split("\n");
			if (!converterFolder.exists()) {
				converterFolder.mkdir();
			}
			try {
				if (converter1.exists()) {
					converter1.delete();
				}
				converter1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FileWriter fw;
			try {
				fw = new FileWriter(converter1, true);
				PrintWriter pw = new PrintWriter(fw);
				for (String s : content1) {
					pw.println(s);
				}
				pw.flush();

				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(firstConverterName + " creado con éxito.");
			// Creación del segundo converter
			String secondConverterName = clase + "ToStringConverter.txt";
			String secondConverterContent = "package converters;\n\nimport org.springframework.core.convert.converter.Converter;\nimport org.springframework.stereotype.Component;\nimport org.springframework.transaction.annotation.Transactional;\n\nimport domain.Consumer;\n\n@Component\n@Transactional\npublic class ConsumerToStringConverter implements Converter<Consumer, String> {\n\n	@Override\n	public String convert(Consumer consumer) {\n		String result;\n\n		if (consumer == null)\n			result = null;\n		else\n			result = String.valueOf(consumer.getId());\n\n		return result;\n	}\n\n}";

			File converter2 = new File(directorio, secondConverterName);
			secondConverterContent = secondConverterContent.replaceAll("consumer", clase.toLowerCase());
			secondConverterContent = secondConverterContent.replaceAll("Consumer", clase);

			String[] content2 = secondConverterContent.split("\n");
			if (!converterFolder.exists()) {
				converterFolder.mkdir();
			}
			try {
				if (converter2.exists()) {
					converter2.delete();
				}
				converter2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FileWriter fw2;
			try {
				fw2 = new FileWriter(converter2, true);
				PrintWriter pw2 = new PrintWriter(fw2);
				for (String s : content2) {
					pw2.println(s);
				}
				pw2.flush();

				pw2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(secondConverterName + " creado con éxito.");

			System.out.println("¿Seguir? Si,No");
			String entradaTeclado2 = "";
			Scanner entradaEscaner2 = new Scanner(System.in);

			entradaTeclado2 = entradaEscaner2.nextLine();

			if (!entradaTeclado2.equals("Si")) {
				continua = false;
			} else {
				System.out.println("¡Hasta luego,gracias por su visita!");
			}
		}
	}

	public static boolean check(String text) {
		if (text.equals("pene") || text.equals("polla") || text.equals("asd") || text.equals("asdasd") || text.equals("asdfg")) {
			return true;
		} else
			return false;
	}
}
