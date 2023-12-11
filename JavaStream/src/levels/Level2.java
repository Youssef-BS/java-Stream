package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.List;
import java.util.stream.Collectors;

public class Level2 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner le nombre des enseignants dont le nom commence avec s */
        long nbr = teachers.stream().filter(t ->
          t.getName().startsWith("s")
        ).count();

        /* TO DO 2: Retourner la somme des salaires de tous les enseignants Flutter (hint: mapToInt) */
        long sum = teachers.stream().filter(teacher -> teacher.getSubject().equals(Subject.FLUTTER))
                .mapToInt(Teacher::getSalary)
                .sum();

        /* TO DO 3: Retourner la moyenne des salaires des enseignants dont le nom commence avec a */
        double average = teachers.stream().filter(teacher -> teacher.getName().startsWith("a"))
                .mapToInt(Teacher::getSalary)
                .average().orElse(0.0);

        /* TO DO 4: Retourner la liste des enseignants dont le nom commence par f */
        List<Teacher> teachers1 = teachers.stream().filter(e -> e.getName().startsWith("f"))
                .collect(Collectors.toList());

        /* TO DO 5: Retourner la liste des enseignants dont le nom commence par s */
        List<Teacher> teachers2 = teachers.stream().filter(e -> e.getName().startsWith("s"))
                .collect(Collectors.toList());

        /* TO DO 6: Retourner true si il y a au moins un enseignant dont le salaire > 100000, false sinon */
        boolean test = teachers.stream().anyMatch(teacher -> teacher.getSalary() > 100000);

        /* TO DO 7: Afficher le premier enseignant Unity dont le nom commence par g avec 2 manières différentes */
        /* First way */
        teachers.stream()
                .filter(teacher -> teacher.getSubject().equals(Subject.UNITY) && teacher.getName().startsWith("g"))
                .findFirst().ifPresent(System.out::println);

        /* Second way */
        Teacher unityTeacher = teachers.stream()
                .filter(teacher -> teacher.getSubject().equals(Subject.UNITY) && teacher.getName().startsWith("g"))
                .findFirst().orElse(null);
        System.out.println(unityTeacher);

//        Teacher unityTeacher1 = teachers.stream()
//                .filter(teacher -> teacher.getSubject().equals(Subject.UNITY) && teacher.getName().startsWith("g"))
//                .limit(1)
//                        .forEach(System.out::println);

        /* TO DO 8: Afficher le deuxième enseignant dont le nom commence avec s */
        teachers.stream()
                .filter(teacher -> teacher.getName().startsWith("s"))
                .skip(1)
                .findFirst().ifPresent(System.out::println);
    }
}
