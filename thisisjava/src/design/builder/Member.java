package design.builder;

public class Member {
    private String id;
    private String pwd;
    private String name;

    // 기본 생성자
    private Member() {
    }

    // 빌더를 통한 생성자
    private Member(MemberBuilder builder) {
        this.id = builder.id;
        this.pwd = builder.pwd;
        this.name = builder.name;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    // 빌더 클래스
    public static class MemberBuilder {
        private String id;
        private String pwd;
        private String name;

        public MemberBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public MemberBuilder setPwd(String pwd) {
            this.pwd = pwd;
            return this;
        }

        public MemberBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }
}
