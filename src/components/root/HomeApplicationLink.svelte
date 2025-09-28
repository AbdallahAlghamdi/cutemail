<script lang="ts">
    let { href, src, alt, text } = $props();
</script>

<li>
    <a {href}>
        <img class="pixel" {src} {alt} title={text} />
        <span>{text}</span>
    </a>
</li>

<style>
    li {
        display: inline;
    }
    a {
        text-decoration: none;
        position: relative;
        padding: 6px 3px;
        display: inline-flex;
        flex-direction: column;
        align-items: center;
        font-size: calc(16px * 1);
        transition: all 0.3s ease-in-out;
    }
    a:hover {
        background-color: #e76a3a;
    }
    span {
        background-color: #30346d;
        color: #e0f8cf;
        padding: 1px 10px;
        font-weight: 600;
        /* width: calc(3px * 15); */
        text-align: center;
        text-transform: capitalize;
    }
</style>
