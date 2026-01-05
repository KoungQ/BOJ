class Solution {
    public String solution(String new_id) {
        String answer = new_id;

        answer = step1(answer);
        answer = step2(answer);
        answer = step3(answer);
        answer = step4(answer);
        answer = step5(answer);
        answer = step6(answer);
        answer = step7(answer);

        return answer;
    }

    public String step1(String id) {
        return id.toLowerCase();
    }

    public String step2(String id) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            if (('a' <= c && c <= 'z')
                    || ('0' <= c && c <= '9')
                    || (c == '-')
                    || (c == '_')
                    || (c == '.')) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public String step3(String id) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            if (c == '.' && i != 0 && id.charAt(i - 1) == '.') continue;
            sb.append(c);
        }

        return sb.toString();
    }

    public String step4(String id) {
        if (id.isEmpty()) 
            return id;

        if (id.charAt(0) == '.') {
            id = id.substring(1);
        }

        if (id.isEmpty()) 
            return id;

        if (id.charAt(id.length() - 1) == '.') {
            id = id.substring(0, id.length() - 1);
        }

        return id;
    }

    public String step5(String id) {
        if (id.isEmpty()) return "a";
        return id;
    }

    public String step6(String id) {
        if (id.length() >= 16) {
            id = id.substring(0, 15);
        }

        if (!id.isEmpty() && id.charAt(id.length() - 1) == '.') {
            id = id.substring(0, id.length() - 1);
        }

        return id;
    }

    public String step7(String id) {
        while(id.length() < 3) {
            id = id + id.charAt(id.length() - 1);
        }
        
        return id;
    }
}
