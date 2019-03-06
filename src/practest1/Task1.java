package practest1;

public class Task1 {

	public static double percentVowels (String s) throws UnexpectedCharacterException
	{
	    char[] chars = s.toCharArray();
	    double vowels = 0;
        for(char i:
            chars){
            if(!Character.isLetter(i)){
                throw new UnexpectedCharacterException();
            }
            if("AEIOU".indexOf(Character.toUpperCase(i)) >=0){
                vowels++;
            }


        }
        return (vowels/(double) chars.length) * 100;
	}
	
	public static void main(String[] args) {
		String[] s = {"Happy", "Jackson", "School Days", "Gr4et", "AeIoU", "b", "16"};

		for (int i=0; i<s.length; i++)
		{
			try {
				System.out.print(s[i] + ": ");
				System.out.printf("%.1f%%\n", percentVowels(s[i]));
			}catch (UnexpectedCharacterException ex) {
				System.out.println("Illegal characters in string!");
			}
		}
	}
}
