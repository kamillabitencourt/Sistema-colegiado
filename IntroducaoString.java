
public class IntroducaoString {
	
    public static void main (String args[]) {
        
        String s1, s2;
                  
         //s1="Helio";
         //s2="Helio";
        
        
         s1 = new String("Helio"); 
         s2 = new String(" Helio");
         System.out.println(s2);
         System.out.println(s2.trim());
         
         
         //System.out.println(s1.hashCode());
         //System.out.println(s2.hashCode());
         
       //  System.out.println(System.identityHashCode(s1));
       //  System.out.println(System.identityHashCode(s2));
           
           if (s1==s2){
            System.out.println("s1 igual a s2");
           }
           
           s1 = s1 + "Santos";
           s2 = s2 + "Santos";
           
           System.out.println(System.identityHashCode(s1));
           System.out.println(System.identityHashCode(s2));
               
           if (s1==s2)
              System.out.println("s1 e s2 sao os mesmos objetos");
           else
              System.out.println("s1 e s2 NAO sao os mesmos objetos");

            if (s1.equals(s2))
                System.out.println("s1 e s2 sao iguais");
            else 
                System.out.println("s1 e s2 sao os mesmos objetos");

       
    }
}