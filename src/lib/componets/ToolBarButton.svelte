<script lang="ts">
    import type { MouseEventHandler } from "svelte/elements";

    interface Props {
        checked: boolean;
        label: string;
        content?: string;
        content_active?: string;
        image?: string;
        onclick: MouseEventHandler<HTMLInputElement>;
    }
    let { checked, label, onclick, content, content_active, image }: Props =
        $props();
    let style = image
        ? `--image: url('${image}')`
        : `--content:'${content}'; --content-active:'${content_active || content}'`;
    // const style = `--content:'${content}'; --content-active:'${content_active || content}'`;
    // alert(style);
</script>

<input
    bind:checked
    {onclick}
    title={label}
    aria-label={label}
    type="checkbox"
    {style}
/>

<style>
    @font-face {
        font-family: "Abaddon";
        src: url("/fonts/abaddon/abaddon_light.ttf") format("TrueType");
        font-weight: normal;
        font-style: normal;
    }
    @font-face {
        font-family: "Abaddon";
        src: url("/fonts/abaddon/abaddon_bold.ttf") format("TrueType");
        font-weight: bold;
        font-style: normal;
    }

    input[type="checkbox"] {
        appearance: none;
        color: gray;
        width: 32px;
        height: 32px;
        font-size: 24px;
        background-size: 32px;
        background-image: url("icons/toolbar/button.png");
        display: flex;
        justify-content: center;
        align-items: center;
    }
    input[type="checkbox"]::after {
        font-family: "Abaddon";
        content: var(--content, "");
        background-image: var(--image);
        background-size: 32px;
    }
    input[type="checkbox"]::before {
        position: absolute;
        font-family: "";
        content: "";
        width: 32px;
        height: 32px;
        background-image: var(--image);
        background-size: 32px;
        filter: opacity(0.5);
    }
    /* input[type="checkbox"]::before { */
    /* padding-left: 2px; */
    /* width: 32px; */
    /* height: 32px; */
    /* right: 100px; */
    /* background-size: 32px; */
    /* z-index: 10; */
    /* background-image: url("favicon.png"); */
    /* background-color: red; */
    /* } */
    input[type="checkbox"]:hover {
        padding-top: 2px;
        background-image: url("icons/toolbar/button-hover.png");
    }
    input[type="checkbox"]:active {
        padding-top: 4px;

        background-image: url("icons/toolbar/button-pressed.png");
    }
    input[type="checkbox"]:checked {
        background-image: url("icons/toolbar/button-hover.png");
        font-weight: bold;
        color: #303843;
    }
    input[type="checkbox"]:checked::after {
        content: var(--content-active);
    }
    input[type="checkbox"]:checked::before {
        filter: opacity(1);
    }
    input[type="checkbox"]:checked:active {
        background-image: url("icons/toolbar/button-pressed.png");
    }
</style>
