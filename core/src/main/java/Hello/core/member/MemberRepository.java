package Hello.core.member;

public interface MemberRepository {

    // 회원 저장
    void save(Member member);
    // 회원 Id 찾기
    Member findById(Long memberId);
}
