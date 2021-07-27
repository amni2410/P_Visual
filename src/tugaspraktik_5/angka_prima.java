package tugaspraktik_5;

public class angka_prima {
public static void main(String[] args) {
    System.out.println("Looping Angka Prima: ");
    
    for (int i = 1; i <= 100; i++){
        int j = 0;
        for (int z = 1; z <= i; z++){
            if(i%z == 0)
                j++;
        }
        if (j==2)
        System.out.println(i + " ");
    }  
}
}
