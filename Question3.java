import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Question3 {
    public static void main(String[] args) {
        String filePath = "faturamento.json";

        try {
            String jsonContent = readFile(filePath);

            jsonContent = jsonContent.trim()
                                     .replace("[", "")
                                     .replace("]", "")
                                     .replace("{", "")
                                     .replace("}", "");

            String[] entries = jsonContent.split(",");

            double menor = Double.MAX_VALUE;
            double maior = Double.MIN_VALUE;
            double soma = 0.0;
            int diasComFaturamento = 0;

            for (String entry : entries) {
                if (entry.contains("\"valor")) {
                    String[] keyValue = entry.split(":");
                    String valorStr = keyValue[1].trim();

                    // Ignorar valores nulos
                    if (!valorStr.equals("null")) {
                        double valor = Double.parseDouble(valorStr);
                        menor = Math.min(menor, valor);
                        maior = Math.max(maior, valor);
                        soma += valor;
                        diasComFaturamento++;
                    }
                }
            }

            double media = soma / diasComFaturamento;

            int diasAcimaDaMedia = 0;
            for (String entry : entries) {
                if (entry.contains("\"valor")) {
                    String[] keyValue = entry.split(":");
                    String valorStr = keyValue[1].trim();

                    if (!valorStr.equals("null")) {
                        double valor = Double.parseDouble(valorStr);
                        if (valor > media) {
                            diasAcimaDaMedia++;
                        }
                    }
                }
            }

            System.out.println("Menor faturamento: " + menor);
            System.out.println("Maior faturamento: " + maior);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método de leitura do arquivo JSON
    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
