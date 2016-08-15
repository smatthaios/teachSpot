package gr.teachspot.library.service;

import gr.teachspot.library.domain.Lesson;
import gr.teachspot.library.enumeration.FaultReason;
import gr.teachspot.library.exception.LessonNotFoundException;
import gr.teachspot.library.exception.SecurityException;
import gr.teachspot.library.persistence.LessonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** The type Lesson service impl contains all the business methods related to a {@link Lesson}. */
@Service
public class LessonServiceImpl implements LessonService {

	/** Logger to be used */
	private final static Logger LOG = LoggerFactory.getLogger(LessonServiceImpl.class);

	/** The Lesson Repository. */
	@Autowired
	private LessonRepository lessonRepository;

	/** {@inheritDoc} */
	@Override
	public Lesson find(Long lessonId)  throws LessonNotFoundException {
		Lesson lesson = lessonRepository.find(lessonId);

		if (lesson == null) {
			throw new LessonNotFoundException(String.format("Lesson wasn't found for [id:%s].", lessonId));
		}

		return lesson;
	}

	@Override
	public List<Lesson> get(Long profileId) {
		return lessonRepository.get(profileId);
	}

	@Override
	public void saveOrUpdate(Lesson lesson) {
		if (lesson.getId() != null) {
			lessonRepository.update(lesson);
		}
		else {
			lessonRepository.save(lesson);
		}
	}

	@Override
	public void delete(List<Long> lessonList) {
		for(Long lessonId : lessonList) {
			lessonRepository.delete(lessonId);
		}
	}


}
