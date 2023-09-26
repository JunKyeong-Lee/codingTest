import java.util.Scanner;

// https://www.acmicpc.net/problem/17114
public class Application1 {
    /*
     * 1. 처음 입력 받을 때, 0의 개수 체크.
     * 2. 최종 목표는 0의 개수가 0이 되는 경우.
     * 2-1. 0의 개수가 0이 되는 경우 곧장 탈출하고 반복 횟수를 넘기는 것으로 종료
     * 2-2. 0의 개수가 0이 아닌데도, 다음 경우로 넘어갔을때 0의 개수가 변화가 없다면.
     *   실패한 것
     *
     * 3. 재귀함수를 통해 실행한다. 그러다가 언젠간 끝난다.
     *   물론 내부적으로 0의 개수를 세어야 한다. 또한 횟수를 늘려야 한다.
     *       횟수의 경우 매개변수로 하여서 계속해서 return 하도록함
     *           int를 리턴하도록.
     * 4. 끝나면 0의 개수를 확인한다
     * 4-1. 0의 개수가 0이 되는 경우에는 모두 채워넣은 셈이므로 반복횟수를 써주고 종료
     * 4-2. 0의 개수가 0이 아닌 경우. 아직 다 못채웠는데 끝낸것이므로 그냥 종료
     *
     * 5. 착각할수 있는데 순환방식은 아님. 경계선에서는 다른 방향으로 안가도록 조절해야됨.
     *
     * */
    public static void main(String[] args) {
        int m, n, o, p, q, r, s, t, u, v, w;
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        o = in.nextInt();
        p = in.nextInt();
        q = in.nextInt();
        r = in.nextInt();
        s = in.nextInt();
        t = in.nextInt();
        u = in.nextInt();
        v = in.nextInt();
        w = in.nextInt();

        int[] zeroCount = {0};

        int rows = n * o * p * q * r * s * t * u * v * w;
        int[][][][][][][][][][][] arr = new int[w][v][u][t][s][r][q][p][o][n][m];
        for (int w_ = 0; w_ < w; w_++) {
            for (int v_ = 0; v_ < v; v_++) {
                for (int u_ = 0; u_ < u; u_++) {
                    for (int t_ = 0; t_ < t; t_++) {
                        for (int s_ = 0; s_ < s; s_++) {
                            for (int r_ = 0; r_ < r; r_++) {
                                for (int q_ = 0; q_ < q; q_++) {
                                    for (int p_ = 0; p_ < p; p_++) {
                                        for (int o_ = 0; o_ < o; o_++) {
                                            for (int n_ = 0; n_ < n; n_++) {
                                                for (int m_ = 0; m_ < m; m_++) {
                                                    arr[w_][v_][u_][t_][s_][r_][q_][p_][o_][n_][m_] = in.nextInt();
                                                    if (arr[w_][v_][u_][t_][s_][r_][q_][p_][o_][n_][m_] == 0)
                                                        zeroCount[0]++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int w_ = 0; w_ < w; w_++) {
            for (int v_ = 0; v_ < v; v_++) {
                for (int u_ = 0; u_ < u; u_++) {
                    for (int t_ = 0; t_ < t; t_++) {
                        for (int s_ = 0; s_ < s; s_++) {
                            for (int r_ = 0; r_ < r; r_++) {
                                for (int q_ = 0; q_ < q; q_++) {
                                    for (int p_ = 0; p_ < p; p_++) {
                                        for (int o_ = 0; o_ < o; o_++) {
                                            for (int n_ = 0; n_ < n; n_++) {
                                                for (int m_ = 0; m_ < m; m_++) {
                                                    if (arr[w_][v_][u_][t_][s_][r_][q_][p_][o_][n_][m_] == 1) {
                                                        fillTomatoes(arr, zeroCount, w_, v_, u_, t_, s_, r_, q_, p_, o_, n_, m_, w, v, u, t, s, r, q, p, o, n, m);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(zeroCount[0]);
    }

    public static void fillTomatoes(int[][][][][][][][][][][] arr, int[] zeroCount, int w_, int v_, int u_, int t_, int s_, int r_, int q_, int p_, int o_, int n_, int m_, int w, int v, int u, int t, int s, int r, int q, int p, int o, int n, int m) {
        for (int i = -1; i <= 1; i += 2) {
            if (w_ + i >= 0 && w_ + i < w && arr[w_ + i][v_][u_][t_][s_][r_][q_][p_][o_][n_][m_] == 0) {
                arr[w_ + i][v_][u_][t_][s_][r_][q_][p_][o_][n_][m_] = 1;
                zeroCount[0]--;
                fillTomatoes(arr, zeroCount, w_ + i, v_, u_, t_, s_, r_, q_, p_, o_, n_, m_, w, v, u, t, s, r, q, p, o, n, m);
            }
            if (v_ + i >= 0 && v_ + i < v && arr[w_][v_ + i][u_][t_][s_][r_][q_][p_][o_][n_][m_] == 0) {
                arr[w_][v_ + i][u_][t_][s_][r_][q_][p_][o_][n_][m_] = 1;
                zeroCount[0]--;
                fillTomatoes(arr, zeroCount, w_, v_ + i, u_, t_, s_, r_, q_, p_, o_, n_, m_, w, v, u, t, s, r, q, p, o, n, m);
            }
            if (u_ + i >= 0 && u_ + i < u && arr[w_][v_][u_ + i][t_][s_][r_][q_][p_][o_][n_][m_] == 0) {
                arr[w_][v_][u_ + i][t_][s_][r_][q_][p_][o_][n_][m_] = 1;
                zeroCount[0]--;
                fillTomatoes(arr, zeroCount, w_, v_, u_ + i, t_, s_, r_, q_, p_, o_, n_, m_, w, v, u, t, s, r, q, p, o, n, m);
            }
            if (t_ + i >= 0 && t_ + i < t && arr[w_][v_][u_][t_ + i][s_][r_][q_][p_][o_][n_][m_] == 0) {
                arr[w_][v_][u_][t_ + i][s_][r_][q_][p_][o_][n_][m_] = 1;
                zeroCount[0]--;
                fillTomatoes(arr, zeroCount, w_, v_, u_, t_ + i, s_, r_, q_, p_, o_, n_, m_, w, v, u, t, s, r, q, p, o, n, m);
            }
            if (s_ + i >= 0 && s_ + i < s && arr[w_][v_][u_][t_][s_ + i][r_][q_][p_][o_][n_][m_] == 0) {
                arr[w_][v_][u_][t_][s_ + i][r_][q_][p_][o_][n_][m_] = 1;
                zeroCount[0]--;
                fillTomatoes(arr, zeroCount, w_, v_, u_, t_, s_ + i, r_, q_, p_, o_, n_, m_, w, v, u, t, s, r, q, p, o, n, m);
            }
            if (r_ + i >= 0 && r_ + i < r && arr[w_][v_][u_][t_][s_][r_ + i][q_][p_][o_][n_][m_] == 0) {
                arr[w_][v_][u_][t_][s_][r_ + i][q_][p_][o_][n_][m_] = 1;
                zeroCount[0]--;
                fillTomatoes(arr, zeroCount, w_, v_, u_, t_, s_, r_ + i, q_, p_, o_, n_, m_, w, v, u, t, s, r, q, p, o, n, m);
            }
            if (q_ + i >= 0 && q_ + i < q && arr[w_][v_][u_][t_][s_][r_][q_ + i][p_][o_][n_][m_] == 0) {
                arr[w_][v_][u_][t_][s_][r_][q_ + i][p_][o_][n_][m_] = 1;
                zeroCount[0]--;
                fillTomatoes(arr, zeroCount, w_, v_, u_, t_, s_, r_, q_ + i, p_, o_, n_, m_, w, v, u, t, s, r, q, p, o, n, m);
            }
            if (p_ + i >= 0 && p_ + i < p && arr[w_][v_][u_][t_][s_][r_][q_][p_ + i][o_][n_][m_] == 0) {
                arr[w_][v_][u_][t_][s_][r_][q_][p_ + i][o_][n_][m_] = 1;
                zeroCount[0]--;
                fillTomatoes(arr, zeroCount, w_, v_, u_, t_, s_, r_, q_, p_ + i, o_, n_, m_, w, v, u, t, s, r, q, p, o, n, m);
            }
            if (o_ + i >= 0 && o_ + i < o && arr[w_][v_][u_][t_][s_][r_][q_][p_][o_ + i][n_][m_] == 0) {
                arr[w_][v_][u_][t_][s_][r_][q_][p_][o_ + i][n_][m_] = 1;
                zeroCount[0]--;
                fillTomatoes(arr, zeroCount, w_, v_, u_, t_, s_, r_, q_, p_, o_ + i, n_, m_, w, v, u, t, s, r, q, p, o, n, m);
            }
            if (n_ + i >= 0 && n_ + i < n && arr[w_][v_][u_][t_][s_][r_][q_][p_][o_][n_ + i][m_] == 0) {
                arr[w_][v_][u_][t_][s_][r_][q_][p_][o_][n_ + i][m_] = 1;
                zeroCount[0]--;
                fillTomatoes(arr, zeroCount, w_, v_, u_, t_, s_, r_, q_, p_, o_, n_ + i, m_, w, v, u, t, s, r, q, p, o, n, m);
            }
            if (m_ + i >= 0 && m_ + i < m && arr[w_][v_][u_][t_][s_][r_][q_][p_][o_][n_][m_ + i] == 0) {
                arr[w_][v_][u_][t_][s_][r_][q_][p_][o_][n_][m_ + i] = 1;
                zeroCount[0]--;
                fillTomatoes(arr, zeroCount, w_, v_, u_, t_, s_, r_, q_, p_, o_, n_, m_ + i, w, v, u, t, s, r, q, p, o, n, m);
            }
        }
    }
}
