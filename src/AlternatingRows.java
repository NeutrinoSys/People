public class AlternatingRows {
    public static void main(String[] args) {
        int totalRows = 20;
        String backgroundColor = "gray";
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            int result = rowNum % 2;
            backgroundColor = rowNum % 2 == 0 ? "gray" : "white"; // If rowNum is even, then gray, otherwise, it's white
            System.out.format("Row number %d is %s with result %d.\n", rowNum, backgroundColor, result);
        }
    }
}
