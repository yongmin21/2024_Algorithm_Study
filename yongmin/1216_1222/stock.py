from collections import deque

def solution(prices):
    prices = deque(prices)  # 주식 가격을 큐로 변환
    seconds = []  # 결과를 저장할 리스트
    
    while prices:
        current = prices.popleft()  # 현재 가격
        count = 0  # 지속 시간 초기화
        
        # 나머지 가격들과 비교하여 지속 시간 계산
        for price in prices:
            count += 1
            if price < current:
                break  # 가격이 떨어지면 종료
        
        seconds.append(count)  # 결과 저장
    
    return seconds
