package anno.study.ex04;

import org.springframework.stereotype.Component;

//@Component   //xml �� �ڵ����,�̰��� Ŭ�����̸��� �� ���̵� �ȴ�(�� ù���ڴ� �ҹ��ڷ� ����)

@Component("h") //���̵� h �� ���
public class Hello {
	public void showMessage()
	{
		System.out.println("Hello class �� ���� �޼ҵ��Դϴ�");
	}
}