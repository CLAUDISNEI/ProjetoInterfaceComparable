package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import model.entities.Funcionario;

public class ProgramaInterfaceComparable {

	public static void main(String[] args) {
		
		List<Funcionario> list = new ArrayList<>();
		String path = "D:\\funcionario.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String funcionarioCsv = br.readLine();
			System.out.println(funcionarioCsv);
			while(funcionarioCsv != null) {
				String[] campos = funcionarioCsv.split(",");
				list.add(new Funcionario(campos[0], Double.parseDouble(campos[1])));
				funcionarioCsv = br.readLine();
				
			}
			Collections.sort(list);
			for(Funcionario emp: list) {
				System.out.println(emp.getNome() + ", " + emp.getSalary());;
			}
		}
		catch(IOException e) {
			System.out.println("Error: "+ e.getMessage());
		}

	}

}
