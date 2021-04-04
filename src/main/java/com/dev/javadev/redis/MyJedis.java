package com.dev.javadev.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class MyJedis {

    private final Jedis jedis;
    Function<Integer, Integer> divideBy10 = (a) -> 10 / a;

    public MyJedis() {
        jedis = new Jedis("http://127.0.0.1:6379");
        IntStream.range(0, 5).forEach(i -> jedis.rpush("todo", String.valueOf(i)));
    }

    public void main() {
        List<String> todos = getKeysInList("todo");
        IntStream.range(0, todos.size()).mapToObj(i -> jedis.rpoplpush("todo", "wip")).forEach(message -> {
            try {
                System.out.println("j'ai réussi à calculer 10 / " + message + " = " + divideBy10.apply(parseInt(message)));

            } catch (Exception e) {
                System.out.println("je n'ai pas réussi avec : " + message);
                /**
                 * Au choix selon le cas métier, le type du message, ou si t'es un mec sympa
                 * 1) je peux remettre le message à gauche dans la liste de "todo"
                 * jedis.lpush("todo", message);
                 * 2) je peux remettre le message à droite dans la liste de "todo", il sera repris par le prochain rpoplpush()
                 * jedis.rpush("todo", message);
                 */
            }
            // je suis obligé de le virer du "wip" manuellement (?) :sad_panda:
            removeAllOfThisMessageFromWip(message);
        });

        System.out.println("Il reste en todo :" + getKeysInList("todo"));
        System.out.println("Il reste en wip :" + getKeysInList("wip"));
    }

    private List<String> getKeysInList(String listName) {
        return jedis.lrange(listName, 0, -1);
    }

    private void removeAllOfThisMessageFromWip(String message) {
        // c'est le 0 qui vire TOUT
        jedis.lrem("wip", 0, message);
    }

}
