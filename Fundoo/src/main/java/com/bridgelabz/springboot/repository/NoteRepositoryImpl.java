package com.bridgelabz.springboot.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.springboot.model.Note;

@Repository
@Transactional
public class NoteRepositoryImpl implements NoteRepository{
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Note saveOrUpdate(Note note) {
		Session session = entityManager.unwrap(Session.class);
		session.save(note);
		return note;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Note searchById(Long noteId) {
		Session session = entityManager.unwrap(Session.class);
		Query<Note> query = session.createQuery("FROM note where noteId=:id");
		query.setParameter("id", noteId);
		return query.uniqueResult();
	}
	
	@Override
	public boolean delete(Note fetchedNote) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(fetchedNote);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Note> getAllNotes(Long userId){
		Session session = entityManager.unwrap(Session.class);
		Query<Note> query = session.createQuery("FROM note where userId=:id");
		query.setParameter("id", userId);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Note> getPinnedNotes(Long userId) {
		Session session = entityManager.unwrap(Session.class);
		Query<Note> query = session.createQuery("FROM note where userId=:id and pinned = true");
		query.setParameter("id", userId);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Note> getTrashedNotes(Long userId){
		Session session = entityManager.unwrap(Session.class);
		Query<Note> query = session.createQuery("FROM note where userId=:id and inTrash = true");
		query.setParameter("id", userId);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Note> getArchievedNotes(Long userId){
		Session session = entityManager.unwrap(Session.class);
		Query<Note> query = session.createQuery("FROM note where userId=:id and archieved=true");
		query.setParameter("id", userId);
		return query.getResultList();
	}
}
