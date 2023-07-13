package projects.service;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import projects.dao.ProjectDao;
import projects.entity.Project;
import projects.exception.DbException;

public class ProjectService {

	private ProjectDao projectDao = new ProjectDao();

	public Project addProject(Project project) throws SQLException {
		return projectDao.insertProject(project);
	}
public List<Project> fetchAllProjects() {
		return projectDao.fetchAllProjects();
	}

	
public Project fetchProjectById(Integer projectId) throws NoSuchElementException, SQLException {
		return projectDao.fetchProjectById(projectId).orElseThrow(
				() -> new NoSuchElementException("Project with project ID= " + projectId + " does not exist."));
	}
//week 11 method for updating project
public void modifyProjectDetails(Project project) {
	if(!projectDao.modifyProjectDetails(project)) {
		throw new DbException("Project with ID=" + project.getProjectId() + " does not exist.");
		
	}
}
//week 11 method for deleting project
public void deleteProject(Integer projectId) {
	if(!projectDao.deleteProject(projectId)) {
		throw new DbException("Project with ID=" + projectId + " does not exist.");
	}
}
}