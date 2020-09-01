package com.myspring.mapper;

import java.util.List;

import com.myspring.domain.BoardVO;
import com.myspring.domain.Criteria;

public interface BoardMapper {

	//�۾���
	public void create(BoardVO vo) throws Exception;
	
	//���� Ŭ�� �� �Ѱǿ� ���� select
	public BoardVO read(BoardVO vo) throws Exception;
	
	//�� ����
	public void update(BoardVO vo) throws Exception;
	
	//�� ����
	public void delete(BoardVO vo) throws Exception;
	
	//����¡ ó�� �ȵ� ��� ����Ʈ
	public List<BoardVO> listAll() throws Exception;
	
	//����¡ ó���� ��� ����Ʈ
	public List<BoardVO> listPage(Criteria cri) throws Exception;

	//����¡ ó���� ���� ī����
	public int getTotalCount(Criteria cri);
	
	//��ȸ �� �߰� ���(������ Ŭ������ ��)
	public void updateViewcnt(BoardVO vo) throws Exception;
	
}

