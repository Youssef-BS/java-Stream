package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.List;

public class Level1 {

    public static void main(String[] args) {
        List<Teacher> employees = Data.employees();

        /*
         * TO DO 1: Afficher tous les enseignants
         */
        employees.stream().forEach(System.out::println);

        /*
         * TO DO 2: Afficher les enseignants dont le nom commence par la lettre n
         */
        employees.stream().filter(f->f.getName().startsWith("n")).forEach(d->System.out.println(d));
        employees.stream().map(b->b.getName()).filter(f->f.startsWith("n")).forEach(d->System.out.println(d));
        /*
         * TO DO 3: Afficher les enseignants dont le nom commence par la lettre n et le salaire > 100000
         */
        employees.stream().filter(teacher -> teacher.getName().startsWith("n"))
                           .filter(teacher -> teacher.getSalary()>100000)
                           .forEach(System.out::println);


        employees.stream().filter(t -> t.getName().startsWith("n"))
                .filter(t-> t.getSalary()>100000)
                        .forEach(System.out::println);


        /*
         * TO DO 4: Afficher les enseignants JAVA triés par salaire (éliminer les redondances)
         */
        System.out.println("to do 4***********");
        employees.stream().filter(teacher -> teacher.getSubject().equals(Subject.JAVA))
                          .sorted( (a,b) -> a.getSalary() - b.getSalary())
                          .forEach(System.out::println);

        /*
         * TO DO 5: Afficher les noms des enseignants dont le salaire > 60000 avec 2 manières différentes
         */

        /* First Way */
        employees.stream().filter(teacher -> teacher.getSalary()>60000)
                           .forEach(teacher -> System.out.println(teacher.getName()));
        /* Second Way */
        employees.stream().filter(teacher -> teacher.getSalary()>60000).map(r->r.getName())
                           .forEach(System.out::println);

        /*
         * TO DO 6:  Ajouter 200 Dt pour les enseignants dont le nom commence par m et afficher celui qui a le salaire le plus élevé
         */
        employees.stream().filter(teacher -> teacher.getName().startsWith("m"))
                .peek(s->s.setSalary(s.getSalary()+200))
                .max( (t1,t2)-> t1.getSalary() - t2.getSalary())
                .ifPresent(System.out::println);
                //.forEach();

    }
}
