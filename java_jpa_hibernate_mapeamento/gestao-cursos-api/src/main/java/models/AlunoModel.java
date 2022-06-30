package models;

import entities.Aluno;
import utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class AlunoModel {

    EntityManager em;

    public void create(Aluno aluno) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação\n");
        }
    }

    public void findById(Long id) {
        em = JPAUtil.getEntityManager();

        Aluno aluno;

        try {
            System.out.println("Iniciando a transação");
            aluno = em.find(Aluno.class, id);
            if (aluno != null) {
                System.out.println("Aluno " + id + " encontrado com sucesso !!!");
                System.out.println(aluno);
                System.out.println(aluno.getTelefones());
                System.out.println(aluno.getEnderecos());
            } else {
                System.out.println("Aluno " + id + " não encontrado !!!");
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar aluno por id !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação\n");
        }
    }

    public void findAll() {
        em = JPAUtil.getEntityManager();

        List<Aluno> alunos;

        try {
            System.out.println("Iniciando a transação");
            alunos = em.createNativeQuery("SELECT * FROM tb_aluno", Aluno.class).getResultList();
            if (alunos.isEmpty()) {
                System.out.println("Nenhum aluno para listar !!!");
            } else {
                System.out.println("Qtde de alunos encontrados : " + alunos.size());
                alunos.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar alunos !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação\n");
        }
    }

    public void update(Aluno aluno) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno " + aluno.getId() + " atualizado com sucesso !!!");
            System.out.println(aluno);
        } catch (Exception e) {
            System.err.println("Erro ao atualizar o aluno " + aluno.getId() + " !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação\n");
        }
    }

    public void delete(Aluno aluno) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Aluno a = em.find(Aluno.class, aluno.getId());
            em.remove(a);
            em.getTransaction().commit();
            System.out.println("Aluno " + aluno.getId() + " deletado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao deletar o aluno " + aluno.getId() + " !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação\n");
        }
    }

}
