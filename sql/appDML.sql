insert into BUILDING values('11', '���빮��', 'âõ�� 31-82 201ȣ', '���ǽ���');
insert into BUILDING values('22', '����', '�ұ��� 16�� 25-7 2��', '����');
insert into BUILDING values('33', '���빮��', '���빮�� 21�� 265-1', '��������');
insert into BUILDING values('44', '������', '����� 136 11-6', '���ǽ���');
insert into BUILDING values('55', '���Ǳ�', '��������Ʈ 3�� 101ȣ', '����');
insert into BUILDING values('66', '����', '��Ʈ�Ͽ콺 �������', '��������');
insert into BUILDING values('77', '���Ǳ�', '���з� 111-2 2��', '���ǽ���');
insert into BUILDING values('88', '���빮��', '�𷡳��� 254-2 101ȣ', '����');
insert into BUILDING values('99', '���Ǳ�', '���μ��ѷ� 78', '����');

insert into PRICE values('1', 0, 0, 80000);
insert into PRICE values('2', 15000, 0, 0);
insert into PRICE values('3', 0, 0, 400000);
insert into PRICE values('4', 25000, 0, 0);
insert into PRICE values('5', 5000, 70, 0);
insert into PRICE values('6', 3000, 30, 0);
insert into PRICE values('7', 50000, 10, 0);
insert into PRICE values('8', 7700, 100, 0);
insert into PRICE values('9', 200000, 40, 0);

insert into SELLER values('seller1', '���Ͽ�', '010-1111-1111');
insert into SELLER values('seller2', '�ڼ���', '010-2222-2222');
insert into SELLER values('seller3', '������', '010-3333-3333');
insert into SELLER values('seller4', '�ִ���', '010-4444-6666' );
insert into SELLER values('seller5', '�����', '010-5555-7777' );

insert into APP values('1', '11', '�Ÿ�', 'seller1', 'TRUE');
insert into APP values('2', '22', '����', 'seller2', 'FALSE');
insert into APP values('3', '33', '�Ÿ�', 'seller3', 'TRUE');
insert into APP values('4', '44', '����', 'seller1', 'FALSE');
insert into APP values('5', '55', '����', 'seller2', 'FALSE');
insert into APP values('6', '66', '����', 'seller5', 'TRUE');
insert into APP values('7', '77', '����', 'seller4', 'TRUE');
insert into APP values('8', '88', '����', 'seller4', 'FALSE');
insert into APP values('9', '99', '����', 'seller4', 'TRUE');

INSERT INTO PROFILE VALUES('henrynoowah', 'henrynoowah', 'seller1');
INSERT INTO PROFILE VALUES('hyungnim', 'khr', 'seller2');
INSERT INTO PROFILE VALUES('parkse', 'pse', 'seller3');
INSERT INTO PROFILE VALUES('woosongsong', 'babo', null);

COMMIT;
