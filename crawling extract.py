from konlpy.tag import Twitter
from collections import Counter
 
 
def get_tags(text, ntags=50):
    spliter = Twitter()
    # konlpy의 Twitter객체
    nouns = spliter.nouns(text)
    # nouns 함수를 통해서 text에서 명사만 분리/추출
    count = Counter(nouns)
    # Counter객체를 생성하고 참조변수 nouns할당
    return_list = []  # 명사 빈도수 저장할 변수
    for n, c in count.most_common(ntags):
        temp = {'tag': n, 'count': c}
        return_list.append(temp)
    # most_common 메소드는 정수를 입력받아 객체 안의 명사중 빈도수
    # 큰 명사부터 순서대로 입력받은 정수 갯수만큼 저장되어있는 객체 반환
    # 명사와 사용된 갯수를 return_list에 저장합니다.
    return return_list
 
 
def main():
    text_file_name = "C:/Users/cse/Desktop/crawling.csv"
    # 분석할 파일
    noun_count = 1000
    # 최대 많은 빈도수 부터 20개 명사 추출
    output_file_name = "count.txt"
    # count.txt 에 저장
    open_text_file = open(text_file_name, 'r',-1)
    # 분석할 파일을 open 
    text = open_text_file.read() #파일을 읽습니다.
    tags = get_tags(text, noun_count) # get_tags 함수 실행
    open_text_file.close()   #파일 close
    open_output_file = open(output_file_name, 'w',-1)
    # 결과로 쓰일 count.txt 열기
    for tag in tags:
        noun = tag['tag']
        count = tag['count']
        open_output_file.write('{} {}\n'.format(noun, count))
    # 결과 저장
    open_output_file.close() 
 
if __name__ == '__main__':
    main()
    
    
    
import pandas as pd  
countdata = pd.read_csv('C:/Users/cse/Desktop/count.csv',delimiter=',',encoding='euc-kr')
count = countdata[10:20]

import numpy as np
count_n = np.array(count)

listdata = pd.read_excel('C:/Users/cse/Desktop/서울관광명소list_통합.xlsx')
listdata_s = listdata['title2']

for i in range(len(listdata_s)) :
    for j in range(len(count_n)):
        if count_n[j][0] in listdata_s[i]:
            print('크롤링 단어 : ' + count_n[j][0])
            print('관광지 단어 : ' + listdata_s[i])
        