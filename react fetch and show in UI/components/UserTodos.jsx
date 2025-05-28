// Additional features:
// - Pagination
// - Filtering by completion status
// - Better UI with styling
import React, { useState, useEffect } from 'react';
import './UserTodos.css'; // We'll create this next

const EnhancedUserTodos = () => {
    const [todos, setTodos] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [page, setPage] = useState(1);
    const [showCompleted, setShowCompleted] = useState(false);
  
    useEffect(() => {
      const fetchTodos = async () => {
        try {
          setLoading(true);
          const response = await fetch(
            `https://jsonplaceholder.typicode.com/todos?_page=${page}&_limit=10`
          );
          if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
          const data = await response.json();
          setTodos(data);
        } catch (err) {
          setError(err.message);
        } finally {
          setLoading(false);
        }
      };
  
      fetchTodos();
    }, [page]);
  
    const filteredTodos = showCompleted 
      ? todos.filter(todo => todo.completed)
      : todos;
  
    return (
      <div className="todos-container">
        <h1>User Todos</h1>
        
        <div className="controls">
          <button onClick={() => setPage(p => Math.max(1, p - 1))}>
            Previous Page
          </button>
          <span>Page {page}</span>
          <button onClick={() => setPage(p => p + 1)}>
            Next Page
          </button>
          
          <label>
            <input 
              type="checkbox" 
              checked={showCompleted}
              onChange={() => setShowCompleted(!showCompleted)}
            />
            Show only completed
          </label>
        </div>
  
        {loading ? (
          <div>Loading...</div>
        ) : error ? (
          <div>Error: {error}</div>
        ) : (
          <ul className="todos-list">
            {filteredTodos.map(todo => (
              <li key={todo.id} className={`todo-item ${todo.completed ? 'completed' : ''}`}>
                <h3>{todo.title}</h3>
                <p>User ID: {todo.userId}</p>
                <p>Status: {todo.completed ? '✅ Completed' : '⏳ Pending'}</p>
              </li>
            ))}
          </ul>
        )}
      </div>
    );
  };
  export default EnhancedUserTodos;