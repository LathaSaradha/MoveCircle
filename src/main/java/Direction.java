public enum Direction {

    UP('U'){
        @Override
        public int[] updateCoordinates(int[] coords, int spaces) {

            int[] returncords=new int[coords.length];
            returncords[0]= coords[0];

            returncords[1]=coords[1]-spaces;

            return returncords;
        }
    }, DOWN('D') {
        @Override
        public int[] updateCoordinates(int[] coords, int spaces) {
            int[] returncords=new int[coords.length];
            returncords[0]= coords[0];

            returncords[1]=coords[1]+spaces;

            return returncords;
        }
    }, LEFT('L') {
        @Override
        public int[] updateCoordinates(int[] coords, int spaces) {
            int[] returncords=new int[coords.length];
            returncords[0]= coords[0]-spaces;
            returncords[1]= coords[1];

            return returncords;
        }
    }, RIGHT('R') {
        @Override
        public int[] updateCoordinates(int[] coords, int spaces) {
            int[] returncords=new int[coords.length];
            returncords[0]= coords[0]+spaces;
            returncords[1]= coords[1];

            return returncords;
        }
    };
    private char direc;
    private int val;

    Direction(char c,int val)
    {
        this.direc=c;
        this.val=val;
    }

    Direction(char u) {
        this.direc=u;
    }

    public abstract int[] updateCoordinates(int[] coords,int spaces);

    public static int[] getNewCoordinatesForDirection(char direction,int[] coords,int spaces)
    {
        for (Direction d: Direction.values()) {
            if (d.direc == direction)
                return d.updateCoordinates(coords,spaces);
        }
        throw new IllegalArgumentException(direction + ": not a valid  choice");

    }

}
