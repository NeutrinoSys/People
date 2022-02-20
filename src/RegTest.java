import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {
    public static void main(String[] args) {
        String schoolRegex = """
# Here are comments now...
.*Student\\sNumber:\\s+(?<studentNum>\\d{10}) # Get the student number
.*Grade:\\s+(?<grade>\\d{1,2}) # Get the grade here
.*Birthdate:\\s+(?<birthDay>\\d\\d)/(?<birthMonth>\\d\\d)/(?<birthYear>\\d\\d\\d\\d).* # Get the birthdate
.*Gender:\\s+(?<gender>\\w{1,2}).* # Gender
.*State\\sID:\\s+(?<stateID>\\d{1,12}).* # State ID
""";
        String phoneNumber = """
                Student Number:	1234598872
                """;
        String transcript = """
                Student Number:	1234598872			Grade:		11
                Birthdate:		01/02/2000			Gender:	M
                State ID:		8923827123
                                
                Cumulative GPA (Weighted)		3.82
                Cumulative GPA (Unweighted)	3.46
                """;

        Pattern pat = Pattern.compile(schoolRegex,  Pattern.DOTALL | Pattern.COMMENTS);
        Matcher mat = pat.matcher(transcript);
        if (mat.matches()) {
            System.out.println("Matches");
            System.out.println(mat.group("studentNum"));
            System.out.println(mat.group("grade"));
            System.out.println(mat.group("birthDay"));
            System.out.println(mat.group("birthMonth"));
            System.out.println(mat.group("birthYear"));
            System.out.println(mat.group("gender"));
            System.out.println(mat.group("stateID"));
        }
    }
}
