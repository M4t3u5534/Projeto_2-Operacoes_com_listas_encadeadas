//*************************** ATENÇÃO! ****************************
// O método main() deve ser alterado somente nos comentários TODO.
// Todas as outras instruções devem permanecer intactas e o código
// deve funcionar conforme descrito no enunciado da atividade.
//*************************** ATENÇÃO! ****************************
// arquivo: src/MainApl2.java

// Mateus Ribeiro Cerqueira - 10443901
// Pedro Henrique Carvalho Pereira - 10418861

// Sites usados para consultar informações sobre manipulação de arquivos em java:
// https://www-geeksforgeeks-org.translate.goog/writing-a-csv-file-in-java-using-opencsv/?_x_tr_sl=en&_x_tr_tl=pt&_x_tr_hl=pt&_x_tr_pto=sge#:~:text=Crie%20uma%20inst%C3%A2ncia%20de%20CSVWriter,close()%20da%20classe%20CSVWriter
// https://pt.stackoverflow.com/questions/303861/ler-ficheiro-localizado-noutro-package

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import apl2.DLinkedList;
import apl2.LinkedListOriginal;
import apl2.Node;
import apl2.Operation;

public class MainApl2 {
	
	public static void main(String[] args) {
		LinkedListOriginal list = new LinkedListOriginal();
		Scanner input = new Scanner(System.in);

		File file = new File("C:\\Users\\INTEL\\Documents\\Exercícios\\Java\\Projeto_2\\Projeto_2-Operacoes_com_listas_encadeadas-1\\Apl2_arquivosNecessarios\\dados.txt");
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String[] line = scanner.nextLine().split("#");
				list.append(Integer.parseInt(line[0]), line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]));
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println("Arquivo não encontrado!");
		}
		
		System.out.println(">>>>>>>>>> Dados originais (sistema legado) >>>>>>>>>>");
		System.out.println(list);
		System.out.println("<<<<<<<<<< Dados originais (sistema legado) <<<<<<<<<<\n");
		
		DLinkedList fixedList = Operation.map(list);
		System.out.println(">>>>>>>>>> Dados convertidos para a nova representação dos dados >>>>>>>>>>");
		System.out.println(fixedList);
		System.out.println("<<<<<<<<<< Dados convertidos para a nova representação dos dados <<<<<<<<<<\n");
		
		DLinkedList filteredGradedList = Operation.filterRemoveNonGraded(fixedList);
		System.out.println(">>>>>>>>>> Lista filtrada (somente notas válidas) >>>>>>>>>>");
		System.out.println(filteredGradedList);
		System.out.println("<<<<<<<<<< Lista filtrada (somente notas válidas) <<<<<<<<<<\n");
		
		DLinkedList filteredNonGradedList = Operation.filterRemoveGraded(fixedList);
		System.out.println(">>>>>>>>>> Lista filtrada (somente 'ausência de nota') >>>>>>>>>>");
		System.out.println(filteredNonGradedList);
		System.out.println("<<<<<<<<<< Lista filtrada (somente 'ausência de nota') <<<<<<<<<<\n");

		float average = Operation.reduce(filteredGradedList);
		System.out.println(">>>>>>>>>> Média das notas válidas >>>>>>>>>>");
		System.out.println(average);
		System.out.println("<<<<<<<<<< Média das notas válidas <<<<<<<<<<\n");
		
		DLinkedList aboveAverageList = Operation.filterRemoveBelowAverage(filteredGradedList, average);
		System.out.println(">>>>>>>>>> Lista com notas acima da média >>>>>>>>>>");
		System.out.println(aboveAverageList);
		System.out.println("<<<<<<<<<< Lista com notas acima da média <<<<<<<<<<\n");
		
		String contents = Operation.mapToString(fixedList);
		System.out.println(">>>>>>>>>> Lista mapeada para uma única string >>>>>>>>>>");
		System.out.println(contents);
		System.out.println("<<<<<<<<<< Lista mapeada para uma única string <<<<<<<<<<\n");
		
		try (FileWriter writer = new FileWriter("dados.csv")) {
                writer.write(contents);
        } catch (IOException e) {
                e.printStackTrace();
        }
		
		Node test1 = fixedList.getNode("23.S1-999");
		System.out.println(">>>>>>>>>> test1 >>>>>>>>>>\n" + test1 + "\n<<<<<<<<<< test1 <<<<<<<<<<\n");

		Node test2 = fixedList.removeNode("23.S1-999");
		System.out.println(">>>>>>>>>> test2 >>>>>>>>>>\n" + test2 + "\n<<<<<<<<<< test2 <<<<<<<<<<\n");

		Node test3 = fixedList.getNode("23.S1-999");
		System.out.println(">>>>>>>>>> test3 >>>>>>>>>>\n" + test3 + "\n<<<<<<<<<< test3 <<<<<<<<<<\n");

		aboveAverageList.clear();
		System.out.println(">>>>>>>>>> aboveAverageList.clear() >>>>>>>>>>\n" + aboveAverageList + "\n<<<<<<<<<< aboveAverageList.clear() <<<<<<<<<<\n");

		DLinkedList testList = new DLinkedList();
		testList.insert("ABC", "John Doe", 4.7f);
		testList.append("XYZ", "Jane Doe", 9.9f);
		testList.insert("321", "Test", 2.3f);
		testList.append("Nothing", "Yada yada yada", 99.9f);

		System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		System.out.println("testList.getHead(): " + testList.getHead());
		System.out.println("testList.getTail(): " + testList.getTail());
		System.out.println("testList.removeHead(): " + testList.removeHead());
		System.out.println("testList.removeTail(): " + testList.removeTail() + '\n');
		System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		System.out.println("testList.getHead(): " + testList.getHead());
		System.out.println("testList.getTail(): " + testList.getTail());
		System.out.println("testList.removeNode(\"ABC\"): " + testList.removeNode("ABC") + '\n');
		System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		System.out.println("testList.getHead(): " + testList.getHead());
		System.out.println("testList.getTail(): " + testList.getTail() + '\n');

		testList.insert("qwerty", "QWERTY", 1.2f);
		testList.append("WASD", "wasd", 3.4f);
		testList.insert("ijkl", "IJKL", 5.6f);
		testList.append("1234", "Um Dois Tres Quatro", 7.8f);

		System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		testList.clear();
		System.out.println(">>>>>>>>>> testList.clear() >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList.clear() <<<<<<<<<<\n");



		// Processamento das listas
        DLinkedList fixedList_menu = Operation.map(list);
        DLinkedList filteredGradedList_menu = Operation.filterRemoveNonGraded(fixedList_menu);
        DLinkedList filteredNonGradedList_menu = Operation.filterRemoveGraded(fixedList_menu);
        float average_menu = Operation.reduce(filteredGradedList_menu);
        DLinkedList aboveAverageList_menu = Operation.filterRemoveBelowAverage(filteredGradedList_menu, average_menu);
        String contents_menu = Operation.mapToString(fixedList_menu);

        // Geração do arquivo CSV
        try (FileWriter writer = new FileWriter("dados.csv")) {
            writer.write(contents_menu);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Menu interativo
        int opcao = -1;

        while (opcao != 8) {
            System.out.println("\n===== Sistema Conversor de Notas =====");
            System.out.println("1) Dados originais");
            System.out.println("2) Dados convertidos");
            System.out.println("3) Lista notas filtradas válidas");
            System.out.println("4) Lista notas filtradas inválidas");
            System.out.println("5) Média de notas válidas");
            System.out.println("6) Notas acima da média");
            System.out.println("7) Lista mapeada para uma única string");
            System.out.println("8) Sair");
            System.out.print("Escolha uma opção: ");

            opcao = input.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.println(">>>>>>>>>> Dados originais (sistema legado) >>>>>>>>>>");
                    System.out.println(list);
                    System.out.println("<<<<<<<<<< Dados originais (sistema legado) <<<<<<<<<<");
                    break;
                case 2:
                    System.out.println(">>>>>>>>>> Dados convertidos >>>>>>>>>>");
                    System.out.println(fixedList_menu);
                    System.out.println("<<<<<<<<<< Dados convertidos <<<<<<<<<<");
                    break;
                case 3:
                    System.out.println(">>>>>>>>>> Lista filtrada (somente notas válidas) >>>>>>>>>>");
                    System.out.println(filteredGradedList_menu);
                    System.out.println("<<<<<<<<<< Lista filtrada (somente notas válidas) <<<<<<<<<<");
                    break;
                case 4:
                    System.out.println(">>>>>>>>>> Lista filtrada (somente 'ausência de nota') >>>>>>>>>>");
                    System.out.println(filteredNonGradedList_menu);
                    System.out.println("<<<<<<<<<< Lista filtrada (somente 'ausência de nota') <<<<<<<<<<");
                    break;
                case 5:
                    System.out.println(">>>>>>>>>> Média das notas válidas >>>>>>>>>>");
                    System.out.printf("%.2f\n", average_menu);
                    System.out.println("<<<<<<<<<< Média das notas válidas <<<<<<<<<<");
                    break;
                case 6:
                    System.out.println(">>>>>>>>>> Lista com notas acima da média >>>>>>>>>>");
                    System.out.println(aboveAverageList_menu);
                    System.out.println("<<<<<<<<<< Lista com notas acima da média <<<<<<<<<<");
                    break;
                case 7:
                    System.out.println(">>>>>>>>>> Lista mapeada para uma única string >>>>>>>>>>");
                    System.out.println(contents_menu);
                    System.out.println("<<<<<<<<<< Lista mapeada para uma única string <<<<<<<<<<");
                    break;
                case 8:
                    System.out.println("Sistema finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        input.close();
	}

}
