
class TestMemberOuter1{
 private int data=30;
 class Inner{
  void msg(){System.out.println("data is "+data);}
 }
 
 void display(){
  Inner in=new Inner();
  in.msg();
 }

}