-- BUILDING
INSERT INTO BUILDING VALUES('11', '���빮��', 'âõ�� 31-82 201ȣ', '���ǽ���');
INSERT INTO BUILDING VALUES('22', '����', '�ұ��� 16�� 25-7 2��', '����');
INSERT INTO BUILDING VALUES('33', '���빮��', '���빮�� 21�� 265-1', '��������');
INSERT INTO BUILDING VALUES('44', '������', '����� 136 11-6', '���ǽ���');
INSERT INTO BUILDING VALUES('55', '���Ǳ�', '��������Ʈ 101ȣ', '����');

-- PRICE
INSERT INTO PRICE VALUES('1', 0, 0, 800000000);
INSERT INTO PRICE VALUES('2', 120000000, 0, 0);
INSERT INTO PRICE VALUES('3', 0, 0, 4000000000);
INSERT INTO PRICE VALUES('4', 250000000, 0, 0);
INSERT INTO PRICE VALUES('5', 50000000, 70, 0);

-- SELLER
INSERT INTO SELLER VALUES('seller1', '���Ͽ�', '010-1111-1111' );
INSERT INTO SELLER VALUES('seller2', '�ڼ���', '010-2222-2222' );
INSERT INTO SELLER VALUES('seller3', '������', '010-3333-3333' );

-- PROFILE
INSERT INTO PROFILE VALUES('henrynoowah', 'henrynoowah', 'seller1');
INSERT INTO PROFILE VALUES('hyungnim', 'khr', 'seller2');
INSERT INTO PROFILE VALUES('parkse', 'pse', 'seller3');
INSERT INTO PROFILE VALUES('woosongsong', 'babo', null);

-- APP
INSERT INTO APP VALUES('1', '11', '�Ÿ�', 'seller1', 'TRUE');
INSERT INTO APP VALUES('2', '22', '����', 'seller2', 'FALSE');
INSERT INTO APP VALUES('3', '33', '�Ÿ�', 'seller3', 'TRUE');
INSERT INTO APP VALUES('4', '44', '����', 'seller1', 'FALSE');
INSERT INTO APP VALUES('5', '55', '����', 'seller2', 'FALSE');

COMMIT;

