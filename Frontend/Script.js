
//devfining constants for API call
const sprintsUrl = 'http://localhost:8888/sprint/sprints';
const usersUrl = 'http://localhost:8888/user/users';
let tasksUrl = 'http://localhost:8888/task/tasks';

let sprints = [];
let users = [];
let tasks = [];

const createTaskForm = document.querySelector('#create-task-form');
const taskTableBody = document.querySelector('#tasks table tbody');

// API Calles to get Sprint details
function populateSprintDropdown() {
  fetch(sprintsUrl)
    .then(response => response.json())
    .then(data => {
      sprints = data;
      const sprintDropdown = createTaskForm.elements.sprint;
      sprints.forEach(sprint => {
        const option = document.createElement('option');
        option.value = sprint.id;
        option.textContent = sprint.name;
        sprintDropdown.appendChild(option);
      });
    })
    .catch(error => console.log(error));
}

// API Calles to get User details for assignee
function populateAssigneeDropdown() {
  fetch(usersUrl)
    .then(response => response.json())
    .then(data => {
      users = data;
      const assigneeDropdown = createTaskForm.elements.assignee;
      users.forEach(user => {
        const option = document.createElement('option');
        option.value = user.id;
        option.textContent = user.name;
        assigneeDropdown.appendChild(option);
      });
    })
    .catch(error => console.log(error));
}

// API Calles to get Task details and showing it in the table
function getTasks() {
    fetch(tasksUrl)
      .then(response => response.json())
      .then(data => {
        tasks = data;
        displayTasks();
      })
      .catch(error => console.log(error));
  }

// function for displaying the task details in the table
function displayTasks() {
  taskTableBody.innerHTML = '';
  tasks.forEach(task => {
    const row = document.createElement('tr');
    row.innerHTML = `
      <td>${task.title}</td>
      <td>${task.type}</td>
      <td>${sprints.find(sprint => sprint.id === task.sprint).name}</td>
      <td>${users.find(user => user.id === task.assignee).name}</td>
      <td class="status-${task.status}">${task.status.toUpperCase()}</td>
    `;
    taskTableBody.appendChild(row);
  });
}


// adding tasks 
function addTask(task) {
  fetch(tasksUrl, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(task)
  })
    .then(response => response.json())
    .then(data => {
      tasks.push(data);
      displayTasks();
    })
    .catch(error => console.log(error));
}

// create task on form submit
createTaskForm.addEventListener('submit', event => {
  event.preventDefault();
  const title = createTaskForm.elements.title.value;
  const type = createTaskForm.elements.type.value;
  const sprint = Number(createTaskForm.elements.sprint.value);
  const assignee = Number(createTaskForm.elements.assignee.value);
  const status = createTaskForm.elements.status.value;
  const task = { title, type, sprint, assignee, status };
  addTask(task);
  createTaskForm.reset();
});


window.addEventListener('load', () => {
  populateSprintDropdown();
  populateAssigneeDropdown();
  getTasks();
});
