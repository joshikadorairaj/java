class localInner{
 private int data=30;//instance variable
 void display(){
  int value=50;//local variable must be final
  class Local{
   void msg(){System.out.println(value);}//C.T.Error
  }
  Local l=new Local();
  l.msg();
 }

}

