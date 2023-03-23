


	import java.util.Scanner;

	public class SalingView {

		public void settlementView() {
			
			Scanner sc = new Scanner(System.in);
			int day = 1; // 회차
			int guest = 5; // 손님수
			int loan = 5000; // 대출금
			int money = 5000; // 잔액
			int interest = 500; // 대출금 이자
			int salesum = 2200; // 판매금액합계 
			int buysum = 1000; // 구입금액합계
			
			
			System.out.println("=========== 일 일 결 산===========\n");
			System.out.println(day + "일차 매출");
			System.out.printf("1. 아메리카노 %d개 x 200kh = %5dkh\n",guest,guest*200);
			System.out.printf("2.     라떼 %d개 x 250kh = %5dkh\n",guest,guest*250);
			System.out.printf("3. 에스프레소 %d개 x 300kh = %5dkh\n",guest,guest*300);
			System.out.printf("4.    베이글 %d개 x 200kh = %5dkh\n",guest,guest*200);
			System.out.printf("5.    케이크 %d개 x 400kh = %5dkh\n",guest,guest*400);
			System.out.printf("6.  샌드위치 %d개 x 150kh = %5dkh\n",guest,guest*150);
			System.out.println();
			
			System.out.println(day + "일차 비용");
			System.out.printf("1.대출금 이자 : %d\n",interest);
			System.out.printf("2.판매금액 : %d\n",salesum);
			System.out.println();
			System.out.printf("총 매출              +%dkh\n",salesum);
			System.out.printf("총 지출              -%dkh\n",buysum);
			System.out.printf("잔액                %dkh\n",money+salesum-interest-buysum);
			System.out.println();
			
			System.out.println("메인메뉴 돌아가려면 q를 입력해주세요");
			while(true) {
				char select = sc.next().charAt(0);
				if(select == 'q') {
					break;
				}else {
					System.out.println("다시 입력해주세요");
				}
			}
				
		}
		
	}




