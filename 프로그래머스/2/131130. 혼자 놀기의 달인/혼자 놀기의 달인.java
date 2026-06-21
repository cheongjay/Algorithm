import java.util.*;

class Solution {
	public int solution(int[] cards) {
		int answer = 0;

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == -1) {
				continue;
			}
			int idx = i;
			int cnt = 0;
            
            // 새로운 그룹 구하기
			while (cards[idx] != -1) {
				int temp = cards[idx] - 1;
				cards[idx] = -1;
				idx = temp;
				cnt += 1;
			}
			list.add(cnt);
		}

		Collections.sort(list, Collections.reverseOrder());

		if (list.size() >= 2) {
			answer = list.get(0) * list.get(1);
		}
		return answer;
	}
}