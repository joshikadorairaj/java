class TestAnnonymousInner1{  
 public static void main(String args[]){  
 
  Eatable e= new Eatable() //anonymous inner type(one of the type of object creation)
  {
    @Override
    public void eat() {
      // TODO Auto-generated method stub
      //throw new UnsupportedOperationException("Unimplemented method 'eat'");
      System.out.println("nice fruits");
    }
 
      };//anonymous inner class will be created
      e.eat();
   }
  
}  
