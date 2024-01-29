public class FQueue<T> {
    private static class FifoItem <U> {
        public FifoItem( U pItem) throws FifoException {
            m_pItem = (pItem!=null) ?  pItem: null;
            m_pNext = null;
        };
        private U m_pItem;
        private FifoItem<U> m_pNext;
    };

    private FifoItem<T> m_pHead;
    private FifoItem<T> m_pTail;
    public FQueue( ){
            m_pHead = new FifoItem<>(null);
            m_pTail = m_pHead;
    }
    public boolean FQEmpty( ){
        return m_pHead.m_pNext == null;
    }
    public int FQEnqueue( T FifoInfo ){
        FifoItem<T> pItem = new FifoItem<T>( FifoInfo );
        if( pItem==null ) throw new FifoException( ErrCode.FIFO_ALLOCATION_ERROR );

        if( FQEmpty( ) )
            m_pHead.m_pNext = pItem;
        else
            m_pTail.m_pNext = pItem;

        m_pTail = pItem;
        return 1;
    }

    public T FQDequeue( ){
        if( FQEmpty( ) ) throw new FifoException(ErrCode.FIFO_QUEUE_EMPTY);
        T FifoItem = m_pHead.m_pNext.m_pItem;
        FQDel( );
        return FifoItem;
    }

    public void FQClear( ){
        if( FQEmpty( ) ) return;
        while( !FQEmpty( ) )
            FQDel( );
    }

    private void FQDel( ){
            if( FQEmpty( ) ) return;

            FifoItem<T> pom = m_pHead;
            m_pHead = pom.m_pNext;
            if( FQEmpty( ) ){
                m_pTail = null;
                m_pHead.m_pNext = null;
            }
    }
};



/* FifoException*/
enum ErrCode{
    FIFO_ALLOCATION_ERROR(3),FIFO_MISSING_QUEUE(2),  FIFO_QUEUE_EMPTY(1), OTHER_ERROR(0) ;
    int mCode;
    ErrCode(int code){
        mCode=code;
    }
}
class FifoException extends RuntimeException{
    public FifoException(ErrCode errCode){m_errCode=errCode;}
    ErrCode m_errCode;
    public  String getReason( ){
        switch( m_errCode )
        {
            case FIFO_ALLOCATION_ERROR: return  "Allocation error!\n";
            case FIFO_MISSING_QUEUE: return "Missing queue!\n";
            case FIFO_QUEUE_EMPTY: return "Empty queue!\n";
            case OTHER_ERROR: return "Other error!\n";
            default: return "Unknown error!\n";
        }
    }
}