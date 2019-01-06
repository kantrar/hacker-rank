public class StringCalculator {

    public int add(String stringInput) {
        if(stringInput.equals("")){
            return 0;
        }
        String[] stringArray = stringInput.split(",");
        int sum = 0;
        for (String singleString : stringArray) {
            sum += Integer.parseInt(singleString.replaceAll(" ", ""));
        }
        return sum;
    }
}
