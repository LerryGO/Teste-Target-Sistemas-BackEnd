public class Question4 {
    public static void main(String[] args) {
        double SP = 67836.43, RJ = 36678.66, MG = 29229.88, ES = 27165.48, Outros = 19849.53;
        double total = SP + RJ + MG + ES + Outros;

        System.out.printf("SP: %.2f%%%n", (SP / total) * 100);
        System.out.printf("RJ: %.2f%%%n", (RJ / total) * 100);
        System.out.printf("MG: %.2f%%%n", (MG / total) * 100);
        System.out.printf("ES: %.2f%%%n", (ES / total) * 100);
        System.out.printf("Outros: %.2f%%%n", (Outros / total) * 100);
    }
}
