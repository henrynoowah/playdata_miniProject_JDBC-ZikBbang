insert into BUILDING values('11', '서대문구', '창천동 31-82 201호', '오피스텔');
insert into BUILDING values('22', '은평구', '불광로 16길 25-7 2층', '원룸');
insert into BUILDING values('33', '서대문구', '서대문구 21길 265-1', '전원주택');
insert into BUILDING values('44', '강남구', '역삼로 136 11-6', '오피스텔');
insert into BUILDING values('55', '관악구', '은마아파트 3동 101호', '원룸');
insert into BUILDING values('66', '은평구', '펜트하우스 꼭대기층', '전원주택');
insert into BUILDING values('77', '관악구', '대학로 111-2 2층', '오피스텔');
insert into BUILDING values('88', '서대문구', '모래내로 254-2 101호', '원룸');
insert into BUILDING values('99', '관악구', '남부순한로 78', '원룸');

insert into PRICE values('1', 0, 0, 80000);
insert into PRICE values('2', 15000, 0, 0);
insert into PRICE values('3', 0, 0, 400000);
insert into PRICE values('4', 25000, 0, 0);
insert into PRICE values('5', 5000, 70, 0);
insert into PRICE values('6', 3000, 30, 0);
insert into PRICE values('7', 50000, 10, 0);
insert into PRICE values('8', 7700, 100, 0);
insert into PRICE values('9', 200000, 40, 0);

insert into SELLER values('seller1', '조하운', '010-1111-1111');
insert into SELLER values('seller2', '박서은', '010-2222-2222');
insert into SELLER values('seller3', '곽형림', '010-3333-3333');
insert into SELLER values('seller4', '주단태', '010-4444-6666' );
insert into SELLER values('seller5', '우아한', '010-5555-7777' );

insert into APP values('1', '11', '매매', 'seller1', 'TRUE');
insert into APP values('2', '22', '전세', 'seller2', 'FALSE');
insert into APP values('3', '33', '매매', 'seller3', 'TRUE');
insert into APP values('4', '44', '전세', 'seller1', 'FALSE');
insert into APP values('5', '55', '월세', 'seller2', 'FALSE');
insert into APP values('6', '66', '월세', 'seller5', 'TRUE');
insert into APP values('7', '77', '월세', 'seller4', 'TRUE');
insert into APP values('8', '88', '월세', 'seller4', 'FALSE');
insert into APP values('9', '99', '월세', 'seller4', 'TRUE');

COMMIT;
