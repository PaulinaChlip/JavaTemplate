public class Main {
    public static void main(String[] args) {
        try {
            FQueue<Integer> FIFO = new FQueue<>();
            boolean x = FIFO.FQEmpty();
            System.out.println("Czy kolejka pusta: " + x);
            FIFO.FQEnqueue( 13 );
            FIFO.FQEnqueue( 7 );
            FIFO.FQEnqueue( 19);
            x = FIFO.FQEmpty( );
            System.out.println("Czy kolejka pusta: "+ x);

            System.out.println(FIFO.FQDequeue());
            System.out.println(FIFO.FQDequeue());
            x = FIFO.FQEmpty( );
            System.out.println("Czy kolejka pusta: "+ x);
            FIFO.FQEnqueue( 23);
            System.out.println(FIFO.FQDequeue());
            x = FIFO.FQEmpty( );
            System.out.println("Czy kolejka pusta: "+ x);
            System.out.println(FIFO.FQDequeue());
            x = FIFO.FQEmpty( );
            System.out.println("Czy kolejka pusta: "+ x);
            System.out.println(FIFO.FQDequeue());
        }
        catch( FifoException except ) {
            System.out.println(except.getReason( ));
        }
	    catch( Exception e) {
            System.out.println("Caught all other exceptions.");
        }

    }
}