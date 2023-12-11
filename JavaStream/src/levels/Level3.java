package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.*;
import java.util.stream.Collectors;

public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();
        /* TO DO 1: Retourner une chaîne de caractères qui contient tous les noms des enseignants en majuscule séparés par # */
        String names = teachers.stream()
                .map(Teacher::getName)
                .map(String::toUpperCase)
                .collect(Collectors.joining("#"));

//        teachers.stream().map(teacher::getNom).reduce((s1 , s2)->s1.toUpperCase()+"#"+s2.toUpperCase()).get();

        /* TO DO 2: Retourner un set d'enseignants Java dont le salaire > 80000 */
        Set<Teacher> teachers1 = teachers.stream()
                .filter(teacher -> teacher.getSubject().equals(Subject.JAVA) && teacher.getSalary() > 80000)
                .collect(Collectors.toSet());
        /* TO DO 3: Retourner un TreeSet d'enseignants (tri par nom et en cas d'égalité tri par salaire) */
        TreeSet<Teacher> teachers2 = teachers.stream()
                .collect(Collectors.toCollection(() ->
                        new TreeSet<>(Comparator.comparing(Teacher::getName)
                                .thenComparingInt(Teacher::getSalary))));
        /* TO DO 4: Retourner une Map qui regroupe les enseignants par module */
        Map<Subject, List<Teacher>> map = teachers.stream()
                .collect(Collectors.groupingBy(Teacher::getSubject));
        /* TO DO 5: Retourner une Map qui regroupe les noms des enseignants par salaire */
        Map<Integer, String> map1 = teachers.stream()
                .collect(Collectors.groupingBy(Teacher::getSalary,
                        Collectors.mapping(Teacher::getName, Collectors.joining(", "))));
    }
}
