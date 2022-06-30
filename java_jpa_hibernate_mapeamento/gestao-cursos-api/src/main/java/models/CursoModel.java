package models;

import entities.Curso;
import utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CursoModel {

    EntityManager em;

    public void create(Curso curso) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("Curso criado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao criar um curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação\n");
        }
    }

    public void findById(Long id) {
        em = JPAUtil.getEntityManager();

        Curso curso;

        try {
            System.out.println("Iniciando a transação");
            curso = em.find(Curso.class, id);
            if (curso != null) {
                System.out.println("Curso " + id + " encontrado com sucesso !!!");
                System.out.println(curso);
                System.out.println(curso.getAlunos());
                System.out.println(curso.getMaterialCurso());
                System.out.println(curso.getProfessor());
            } else {
                System.out.println("Curso " + id + " não encontrado !!!");
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar o curso " + id + " !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação\n");
        }
    }

    public void findAll() {
        em = JPAUtil.getEntityManager();

        List<Curso> cursos;

        try {
            System.out.println("Iniciando a transação");
            cursos = em.createNativeQuery("SELECT * FROM tb_curso", Curso.class).getResultList();
            if (cursos != null) {
                System.out.println("Qtde de cursos encontrados : " + cursos.size());
                cursos.forEach(System.out::println);
            } else {
                System.out.println("Nenhum curso para listar !!!");
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar cursos !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação\n");
        }
    }

    public void update(Curso curso) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
            System.out.println("Curso " + curso.getId() + " atualizado com sucesso !!!");
            System.out.println(curso);
        } catch (Exception e) {
            System.err.println("Erro ao atualizar o aluno " + curso.getId() + " !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação\n");
        }
    }

    public void delete(Curso curso) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Curso c = em.find(Curso.class, curso.getId());
            em.remove(c);
            em.getTransaction().commit();
            System.out.println("Curso " + curso.getId() + " deletado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao deletar o curso " + curso.getId() + " !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação\n");
        }
    }

}
