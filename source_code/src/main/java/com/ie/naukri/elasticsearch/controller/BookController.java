package com.ie.naukri.elasticsearch.controller;

import com.ie.naukri.elasticsearch.bean.Book;
import com.ie.naukri.elasticsearch.dao.BookDao;
import com.ie.naukri.elasticsearch.dao.TestSpark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

	private BookDao bookDao;

	@Autowired
	private TestSpark testSpark;

	public BookController(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	/*@PostMapping
	public Book insertBook(@RequestBody Book book) throws Exception {
		return bookDao.insertBook(book);
	}

	@GetMapping("/{id}")
	public Map<String, Object> getBookById(@PathVariable String id) {
		return bookDao.getBookById(id);
	}

	@PutMapping("/{id}")
	public Map<String, Object> updateBookById(@RequestBody Book book, @PathVariable String id) {
		return bookDao.updateBookById(id, book);
	}

	@DeleteMapping("/{id}")
	public void deleteBookById(@PathVariable String id) {
		bookDao.deleteBookById(id);
	}
*/
	@GetMapping("/sparkTesting")
	public Map<String, String> getSparkStatus() {
		Map<String, String> result = new HashMap<String, String>();
		String message = testSpark.isSparkWorking();
		// String message = bookDao.isSparkWorking();
		result.put("message", message);
		return result;
	}
}
