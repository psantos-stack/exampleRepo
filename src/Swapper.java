class Swapper{
    private int itemOne;
    private int itemTwo;
    public Swapper(){}
    public Swapper(int firstItem, int secondItem){
        itemOne = firstItem;
        itemTwo = secondItem;
    }

    public int getItemOne() {
        return itemOne;
    }

    public int getItemTwo() {
        return itemTwo;
    }

    public void setItemOne(int itemOne) {
        this.itemOne = itemOne;
    }

    public void setItemTwo(int itemTwo) {
        this.itemTwo = itemTwo;
    }
    public void set(int itemOne, int itemTwo){
        this.setItemOne(itemOne);
        this.setItemTwo(itemTwo);
    }
}
