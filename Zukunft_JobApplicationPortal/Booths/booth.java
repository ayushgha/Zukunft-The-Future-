import java.util.*;
import java.lang.*;
public class booth {
	static int size;
		public static void main(String args[])
		{
			
			System.out.println("Enter a decimal value");
			Scanner sc =new Scanner(System.in);
			//int deci=sc.nextInt();
			booth ob=new booth();
			System.out.println("Enter two numbers");
			System.out.println("Enter number 1");
			int n1=sc.nextInt();
			int num1[]=new int[4];
			int number1[]=new int[4];
			
			if(n1>=0)
			{
				num1=ob.bin_convertion(n1);
			//	System.out.println(num1.length);
				if(n1<8)
				{
					for(int j=3;j>0;j--)
					{
						num1[j]=num1[j-1];
					}
					num1[0]=0;
					
				}
				for(int j=0;j<4;j++)
				{
					System.out.print(num1[j]);
				}
			}
			else
			{
				n1=n1*-1;
				num1=ob.bin_convertion(n1);
				if(n1<8)
				{
					for(int j=3;j>0;j--)
					{
						num1[j]=num1[j-1];
					}
					num1[0]=0;
					
				}
				num1=ob.complement(num1);
			
			
			for(int j=0;j<4;j++)
			{
				System.out.print(num1[j]);
			}
		}
			
			for(int i=0;i<4;i++)
			{
			number1[i]=num1[i];
			}
			
			System.out.println("Enter number 2");
			int n2=sc.nextInt();
			int num2[]=new int[4];
			
			if(n2>=0)
			{
				num2=ob.bin_convertion(n2);
				//System.out.println(num1.length);
				if(n2<8)
				{
					for(int j=3;j>0;j--)
					{
						num2[j]=num2[j-1];
					}
					num2[0]=0;
					
				}
				for(int j=0;j<4;j++)
				{
					System.out.print(num2[j]);
				}
			}
			else
			{
				n2=n2*-1;
				num2=ob.bin_convertion(n2);
				if(n2<8)
				{
					for(int j=3;j>0;j--)
					{
						num2[j]=num2[j-1];
					}
					num2[0]=0;
					
				}
				num2=ob.complement(num2);
			
			
			for(int j=0;j<4;j++)
			{
				System.out.print(num2[j]);
			}
		}
			
			//this is specifically for 4 bit numbers, so the number of times the booths cycle will run is 4.
			int A[]=new int[8];
			for(int i=0;i<4;i++)
			{	
				A[i]=0;
			}
			
			int Qm=0;
			
			int Bcomp[]=new int[4];
			Bcomp=ob.complement(num1);
			
			int BC[]=new int [4];
			
			for(int i=0;i<4;i++)
			{
				BC[i]=Bcomp[i];
			}
		
//					
//			System.out.println("THIS IS NUM1 1");
//			
			for(int i=0;i<4;i++)
			{
				num1[i]=number1[i];
			}
			System.out.println("This is num1");
			for(int i=0;i<4;i++)
				{
					System.out.println(BC[i]);
				}
//			for(int i=0;i<4;i++)
//			{
//				System.out.println(num1[i]);
//			}
			int store;
			int temp1[]=new int[10];
			for(int initial=0;initial<4;initial++)
			{
				System.out.println("This is cycle number "+(initial+1));
				if(num2[3]==0 && Qm==1)
				{
					System.out.println("If 01");
//					System.out.println("ORiginal A is ");
//					for(int i=0;i<4;i++)
//					{
//						System.out.print(A[i]);
//					}
//					System.out.println("Number 1");
//					for(int i=0;i<4;i++)
//					{
//						System.out.println(number1[i]);
//					}
//					System.out.println("NUM1 is");
//					for(int i=0;i<4;i++)
//					{
//						System.out.print(num1[i]);
//					}
					A=ob.add(A, num1);
					
					System.out.println("Addition is: ");
					System.out.println();
					for(int i=0;i<4;i++)
					{
						System.out.print(A[i]);
					}
					System.out.println();
					store=A[0];
					Qm=num2[3];
					temp1=ob.rightshift(A, num2);
					for(int i=0;i<8;i++)
					{
						System.out.print(temp1[i]);
					}
					System.out.println();
					for(int i=0;i<4;i++)
					{
						num2[i]=temp1[i+4];
					}
					for(int i=0;i<4;i++)
					{
						A[i]=temp1[i];
					}
					A[0]=store;
					
					System.out.println("Value of Qm  (01) "+Qm);
				}
				else if(num2[3]==1 && Qm==0)
				{
					System.out.println("If 10");
					A=ob.add(A, BC);
					System.out.println("This is B complemnt");
					for(int i=0;i<4;i++)
					{
						System.out.print(BC[i]);
					}
					System.out.println();
					store=A[0];
					Qm=num2[3];
					temp1=ob.rightshift(A, num2);
					for(int i=0;i<8;i++)
					{
						System.out.print(temp1[i]);
					}
					System.out.println();
					for(int i=0;i<4;i++)
					{
						num2[i]=temp1[i+4];
					}
					for(int i=0;i<4;i++)
					{
						A[i]=temp1[i];
					}
					A[0]=store;
					
					System.out.println("Value of Qm (10) "+Qm);
				}
				else if(num2[3]==1 && Qm==1)
				{
					System.out.println("If 11");
					store=A[0];
					Qm=num2[3];
					temp1=ob.rightshift(A, num2);
					for(int i=0;i<8;i++)
					{
						System.out.print(temp1[i]);
					}
					System.out.println();
					for(int i=0;i<4;i++)
					{
						num2[i]=temp1[i+4];
					}
					for(int i=0;i<4;i++)
					{
						A[i]=temp1[i];
					}
					A[0]=store;
					
					System.out.println("Value of Qm (11) in cycle"+Qm);
				}
				else if(num2[3]==0 && Qm==0)
				{
					System.out.println("If 00");
					store=A[0];
					Qm=num2[3];
					temp1=ob.rightshift(A, num2);
					
					for(int i=0;i<8;i++)
					{
						System.out.print(temp1[i]);
					}
					System.out.println();
					for(int i=0;i<4;i++)
					{
						num2[i]=temp1[i+4];
					}
					for(int i=0;i<4;i++)
					{
						A[i]=temp1[i];
					}
					A[0]=store;
					
					System.out.println("Value of Qm (00) "+Qm);
				}
				
				else
				{
					System.out.println("No case applicable");
				}
			}
			
		for(int i=0;i<4;i++)
		{
			System.out.print(A[i]);
		}
		for(int i=0;i<4;i++)
		{
			System.out.print(num2[i]);
		}
		}
			
			
			int[] complement(int comp[])
			{
				
				 for(int i=0;i<4;i++) 
                 {
                 if(comp[i]==1)
                      comp[i]=0;
                 else
                      comp[i]=1;
                 }
				 int cf=1; 
                 for(int i=3;i>=0;i--)
                  {
                    if(comp[i]==1 && cf==1)
                     {
                               cf=1;
                               comp[i]=0;
                    }
                  else if(cf==1)
                      {
                          comp[i]=1;              
                          cf=0;
                          break;
                      }
                  }
				 
				 return comp;
			}
			
			
			int[] bin_convertion(int deci)
			{
				int bin[]=new int[4];
			int fbin[]=new int[4];	
			
			int i = 0;
			int temp=deci;
			
			while(deci!=0)
			{
				bin[i]=deci%2;
				deci=deci/2;
				i++;
				
			}
			//System.out.println("The value of i "+i);
			int r=i;
			for(int j=0;j<i;j++,r--)
			{
				fbin[j]=bin[r-1];
			}
			size=i;
			return fbin;
			}

			
			int [] add(int n1[], int n2[])
			{
				int c=0;
				for(int i=3;i>=0;i--)
				{
					if(n1[i]==1 && n2[i]==1 && c==1)
					{
						n1[i]=1;
						c=1;
					}
					else if(n1[i]==1 && n2[i]==1 && c==0)
					{
						n1[i]=0;
						c=1;
					}
					else if(n1[i]==1 && n2[i]==0 && c==1)
					{
						n1[i]=0;
						c=1;
					}
					else if(n1[i]==1 && n2[i]==0 && c==0)
					{
						n1[i]=1;
						c=0;
					}
					else if(n1[i]==0 && n2[i]==1 && c==1)
					{
						n1[i]=0;
						c=1;
					}
					else if(n1[i]==0 && n2[i]==1 && c==0)
					{
						n1[i]=1;
						c=0;
					}
					else if(n1[i]==0 && n2[i]==0 && c==1)
					{
						n1[i]=1;
						c=0;
					}
					else
						continue;
					if(n1[i]==0 && n2[i]==0 && c==0)
					{
						n1[i]=1;
						c=1;
					}
					
				}
				
				return n1;
			}
			
			
			int [] rightshift(int[] a, int[] num2)
			{
				int j=0;
				for(int i=4;i<8;i++,j++)
				{
					a[i]=num2[j];
				}
				for(int i=7;i>=1;i--)
				{
						a[i]=a[i-1];
				}
					a[0]=0;
				
				
				return a;
			}
}
