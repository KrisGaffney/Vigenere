package ie.gmit.dip;

public class Vigenere {
    private char[] key;
    private static final int MININUM_KEY_LENGTH = 10;
    private char[][] tabulaRecta = { 
		{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'},
		{'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A'},
		{'C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B'},
		{'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C'},
		{'E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D'},
		{'F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E'},
		{'G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F'},
		{'H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G'},
		{'I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H'},
		{'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I'},
		{'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J'},
		{'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K'},
		{'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L'},
		{'N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M'},
		{'O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N'},
		{'P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O'},
		{'Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P'},
		{'R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q'},
		{'S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R'},
		{'T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S'},
		{'U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T'},
		{'V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U'},
		{'W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V'},
		{'X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W'},
		{'Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X'},
		{'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'}
	};
    
     public Vigenere(String key) throws Exception{
        setKey(key);    
     }
     
     public void setKey(String key) throws Exception{
         if (key == null || key.length() < MININUM_KEY_LENGTH) throw new Exception("Invalid key.");
         
         this.key = key.trim().toUpperCase().toCharArray();
     }
     
     
     public String encrypt(String plainText) throws Exception{
         if (!isValidText(plainText)) throw new Exception("Plain Text must be less than key length:" + key.length);
         StringBuilder sb = new StringBuilder();
         
         for (int i = 0; i < plainText.length(); i++){
            sb. append(getEncryptedCharacter(key[i], plainText.charAt(i)));
     }

         return sb.toString();
     }
     //intersection of the row with the key and the col with the char plain.
     private char getEncryptedCharacter(char key, char plain){
         for (int row = 0; row< tabulaRecta.length; row++){
             if (tabulaRecta[row][0] == key){
                 for (int col = 0; col < tabulaRecta[row].length; col++){
                     if (tabulaRecta[0][col] == plain){
                         return tabulaRecta[row][col];
                     }
                 }
             }
         }
         return plain;
     }
     
     public String decrypt(String cipherText) throws Exception{
         if (!isValidText(cipherText)) throw new Exception("Plain Text must be less than key length:" + key.length);
          StringBuilder sb = new StringBuilder();
         
         for (int i = 0; i < cipherText.length(); i++){
            sb. append(getDecryptedCharacter(key[i], cipherText.charAt(i)));
     }

         return sb.toString();
     }
    
    //col with keyword -> Read down to find the cipher char. then read off value in col 0
    
    private char getDecryptedCharacter(char key, char cipher){
        for (int col = 0; col < tabulaRecta[0].length; col++){
            if (tabulaRecta[0][col] == key){
                for (int row = 0; row < tabulaRecta.length; row++){
                    if (tabulaRecta[row][col] == cipher){
                        return tabulaRecta[row][0];
                    }
                }
            }
        }
        
        
        return cipher;
        
    }
    private boolean isValidText(String text){
        if (text != null && text.length() <= key.length){
            return true;
        }else{
            return false;
        }
    }
    public void ensureCapacity(int capacity){
        if (capacity > key.length){
            resize(capacity);
        }
    }
    private void resize(int capacity){
        char[] temp = new char[capacity];
        
        int index = 0;
        
        while (index < temp.length - 1){
            for (int i = 0; i < key.length && index < temp.length - 1; i++){
                temp[index] = key[i];
                index++;
            }
        }
        key = temp;
    }
}