/**
 * Class SimpleBot
 *
 * @author Sergey Iryupin
 * @version 0.2 dated Apr 3, 2016
 */
package bot;
import java.util.*;
import java.util.regex.*;

public class SimpleBot {
    final String BOT_NAME = "Bot: ";
    final String[] COMMON_PHRASES = {
        "��� ������ ������ ����, ��������� � ����� � �� �������.",
        "����� �������� ����� ������� ������, ������ ���� ����.",
        "����� ��� ��� ������/�������� ������ ����� ��������.",
        "�������� � ��������� ���� ������� � ������� ����.",
        "������� ����� ����� ��� ��������������� ������.",
        "����������� ���� ������� ���������������� ���.",
        "����� ����� ������, �� ����� � ��������.",
        "��������� �����, �� ��������� �� ����.",
        "��� ���� ������, ��� ���� ��������.",
        "����� �� ���-�� �� �������������."};
    final String[] ELUSIVE_ANSWERS = {
        "������ ���������, ����� ����-��� �� ��������.",
        "�� ������, ��� ���������� ���� �����������.",
        "����� ����� ���-�� �� �����, ��� �����.",
        "��������, �� ��� ����� ������ ������.",
        "����� ����� ����� ��� �� �����������.",
        "�� ������������� ������ ��� �����?",
        "��������, � ���� ���� ��� �����.",
        "������, �� ��� ���������� ����.",
        "����� ��� ����� ����������?",
        "������� �������� �������."};
    final Map<String, String> ANALYSIS_PATTERNS = new HashMap<String, String>() {{
        // hello
        put("���", "hello");
        put("������", "hello");
        put("�������", "hello");
        put("����������", "hello");
        // who
        put("���\\s.*��", "who");
        put("��\\s.*���", "who");
        // name
        put("���\\s.*�����", "name");
        put("���\\s.*���", "name");
        put("�����\\s.*���", "name");
        // howareyou
        put("���\\s.*����", "howareyou");
        put("���\\s.*�����", "howareyou");
        // whatdoyoudoing
        put("�����\\s.*���", "whatdoyoudoing");
        put("�����\\s.*�����", "whatdoyoudoing");
        put("���\\s.*�������", "whatdoyoudoing");
        put("���\\s.*�����������", "whatdoyoudoing");
        // whattime
        put("�������\\s.*���", "whattime");
        put("�������\\s.*�����", "whattime");
        // whattime
        put("����", "bye");
        put("��\\s.*��������", "bye");
    }};
    final Map<String, String> ANSWERS_BY_PATTERNS = new HashMap<String, String>() {{
        put("hello", "������������, ��� ��� ������.");
        put("who", "� ������� ���-���.");
        put("name", "������ ���� ������ :)");
        put("howareyou", "�������, ��� �������������. � ���� �� ������.");
        put("whatdoyoudoing", "� ������ �������� � ������.");
        put("bye", "�� ��������. �������, ��� ��������.");
    }};
    Pattern pattern; // for regexp
    Random random; // for random answers
    Date date; // for date and time

    public SimpleBot() {
        random = new Random();
        date = new Date();
    }

    String tryToAnswer(String msg, boolean ai, boolean isQuestion) {
        String say = (isQuestion)?
            ELUSIVE_ANSWERS[random.nextInt(ELUSIVE_ANSWERS.length)]:
            COMMON_PHRASES[random.nextInt(COMMON_PHRASES.length)];
        if (ai) {
            String message =
                String.join(" ", msg.toLowerCase().split("[ {,|.}?]+"));
            for (Map.Entry<String, String> o : ANALYSIS_PATTERNS.entrySet()) {
                pattern = Pattern.compile(o.getKey());
                if (pattern.matcher(message).find())
                    if (o.getValue().equals("whattime")) return date.toString();
                    else return ANSWERS_BY_PATTERNS.get(o.getValue());
            }
        }
        return say;
    }

    public String sayInReturn(String msg, boolean ai) {
        return BOT_NAME + tryToAnswer(msg, ai, msg.trim().endsWith("?"));
    }
}