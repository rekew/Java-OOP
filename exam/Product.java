class Product{
    private int id;
    public Product(int id){
        this.id = id;
    }

    public int hashCode(){
        return id + 42;
    }
    
    public boolean equals(Object obj){
        return (this == obj) ? true : super.equals(obj);
    }
}

